package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    public  static boolean checkString(String string) {
        if (string == null) return false;
        return string.matches("^-?\\d+$");
    }
    public static void main(String[] args) {
        //add your code here
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            String  str = reader.readLine();
            String arr  = str.substring(str.indexOf("?")+1);
            int a = str.indexOf("?") + 1;
            String[] mas = arr.split("(\\&+)|(\\?+)");

            for (String s: mas)
            {

                if (s.contains("="))
                {
                    System.out.print(s.substring(0, s.indexOf("=")) + " ");
                } else System.out.print(s + " ");
            }
            System.out.println("");

            String[] array = null;
            for (String s: mas)
            {
                array = s.split("=");

                for (String arq : array)
                {
                    if (arq.equals("obj"))
                    {

                        if (checkString(array[1])) alert(Double.parseDouble(array[1]));
                        else if (array[1].contains("."))
                        {
                            try {
                                alert((Double.parseDouble(array[1])));
                            } catch (NumberFormatException e)
                            {
                                alert(Double.parseDouble(array[1]));
                            }
                        } else alert(array[1]);
                    }
                }

            }


        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
