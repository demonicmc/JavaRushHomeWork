package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Solution {
    public static void main(String[] args) {
        try
        {
            String alpha ="abcdefghijklmnopqrstuvwxyz";
            int count = 0;
            FileReader reader = new FileReader(args[0]);
            String r = null;
            int b = 0;
            while ((b = reader.read()) != -1)
            {
                r = String.valueOf((char) b).toLowerCase();
                if (alpha.contains(r))
                {
                    count++;
                }
            }
            reader.close();
            System.out.println(count);

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
