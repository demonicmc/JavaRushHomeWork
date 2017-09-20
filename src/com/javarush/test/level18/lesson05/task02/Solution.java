package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileReader fileReader = new FileReader(new File(reader.readLine()));
            int a;
            List<String> list = new ArrayList<>();
            while ((a = fileReader.read()) != -1)
            {
                list.add(String.valueOf((char)a));
            }
            reader.close();
            fileReader.close();

            String mas[] = list.toArray(new String[list.size()]);
            int count = 0;
            for (String s:
                 mas)
            {
                if (s.contains(","))
                {
                    count++;
                }

            }

            System.out.println(count);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
