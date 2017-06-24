package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        // напишите тут ваш код
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = reader.readLine();
            BufferedReader reader1 = new BufferedReader((new FileReader(new File(s))));
            String s1;
            List<Integer> list = new ArrayList<>();

            int b = 0;
           while ((s1= reader1.readLine()) != null){
               String[] m = s1.split(" ");
               for (int i = 0; i<m.length; i++){
                   b = Integer.parseInt(m[i]);
                   if(b%2==0) list.add(b);
               }
           }


            reader.close();
            reader1.close();

            Collections.sort(list);
            for (Integer x: list)
            {
                System.out.println(x);
            }

        }

    }
