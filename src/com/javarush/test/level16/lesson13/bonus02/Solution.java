package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);
    static {
        threads.add(new A());
        threads.add(new B());
        threads.add(new C());
        threads.add(new D());
        threads.add(new E());
    }

    public static void main(String[] args) throws InterruptedException
    {
        D d = new D();
        d.start();
        Thread.sleep(2000);

        d.showWarning();
        System.out.println(d.isAlive());
    }


    public static class A extends Thread{
        public void run(){
            while (true){

            }
        }
    }
    public static class B extends Thread{
        public void run(){
            try
            {
                while (!isInterrupted())
                throw new InterruptedException();
            } catch (InterruptedException e)
            {
                System.out.println("InterruptedException");
            }
        }
    }
    public static class C extends Thread{
        public void run(){
            try
            {
                for (;;){
                    Thread.sleep(500);
                    System.out.println("Ура");
                }
            } catch (InterruptedException e)
            {

            }
        }
    }
    public static class D extends Thread implements Message{
        boolean flag = false;
        public void run(){
            while (!isInterrupted()){

            }
        }

        @Override
        public void showWarning()
        {
            interrupt();
            try
            {
                this.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        }
    }
    public static class E extends Thread{
        int sum = 0;
        public void run(){
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
            {
                while (true){
                    String word = reader.readLine();
                    if (word.equals("N")) break;
                    int tmp = Integer.parseInt(word);
                    sum = sum + tmp;
                }
                System.out.println(sum);
            } catch (IOException e){

            }
        }
    }
}
