package com.javarush.test.level18.lesson03.task01;

import java.io.*;
import java.util.*;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            try(FileReader fileReader = new FileReader(new File(reader.readLine())))
            {
                List<Integer> list = new ArrayList<>();
                int a;
                while ((a = fileReader.read()) != -1)
                {
                    list.add(a);
                }
               Collections.sort(list);
                System.out.println(list.get(list.size()-1));
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
