package com.javarush.test.level14.lesson08.bonus01;

import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception

       for (int i = 0; i<10; i++){
            try
            {
                float j = 1 / 0;

            } catch (Exception e)
            {
                exceptions.add(e);
            }
        }


        //Add your code here
//        try
//        {
//            int[] mas = new int[0];
//            mas[1] = 2;
//
//        } catch (Exception e)
//        {
//            exceptions.add(e);
//        }
//
//        try
//        {
//
//
//        } catch (Exception e)
//        {
//            exceptions.add(e);
//        }

    }
}
