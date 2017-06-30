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
    public static void main(String[] args) {
        //add your code here
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            String  str = reader.readLine();
            int a = str.indexOf("?")+1;
            String arr = str.substring(a);
            String tmp = "";
            String[] mas = arr.split("&");
            Double d = null;

           for (int i =0; i<mas.length; i++)
           {
               if (mas[i].contains("=") && !mas[i].contains("obj"))
               {

                   int j = mas[i].indexOf("=");
                   tmp += mas[i].substring(0,j) + " ";
               } else if (!mas[i].contains("="))
               {
                   tmp += mas[i] + " ";
               }
               else if (mas[i].contains("=") && mas[i].contains("obj"))
               {
                   int j = mas[i].indexOf("=");
                   tmp += mas[i].substring(0,j) + " ";
                   String s = mas[i].substring(j+1);
                   d = Double.parseDouble(s);
               }

           }
           if (d != null)
           {
               alert(tmp);
               alert(d);
           }
            else alert(tmp);

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
