package com.javarush.test.level16.lesson13.home06;

/* Создание по образцу
Разберись, как работает программа.
По образу и подобию CountDownRunnable создай нить CountUpRunnable, которая выводит значения в нормальном порядке - от 1 до number
*/

public class Solution {
    public static int number = 5;

    public static void main(String[] args) {
        new CountDownRunnable("было");
        new CountUpRunnable("стало");
    }

    //Add your code below - добавьте код ниже
    public static class CountUpRunnable implements Runnable {
        public CountUpRunnable(String name) {
            c = new Thread(this, name);
            c.start();
        }
        private int countIndexDown = 1;
        private Thread c;

        public void run() {
            try
            {
                for (int i = 1; i<=number; i++)
                {
                    System.out.println(toString());
                    countIndexDown = countIndexDown + 1;
//                    if (countIndexDown == 0) return;
                    Thread.sleep(500);
                }
            }

                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
             public String toString() {
            return c.getName() + ": " + countIndexDown;
        }
        }



    public static class CountDownRunnable implements Runnable {
        private int countIndexDown = Solution.number;
        private Thread t;

        public CountDownRunnable(String name) {
            t = new Thread(this, name);
            t.start();
        }

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexDown -= 1;
                    if (countIndexDown == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return t.getName() + ": " + countIndexDown;
        }
    }
}
