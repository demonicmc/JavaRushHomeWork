package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = null;
        BufferedReader reader = null;
        BufferedWriter bw = null;
        try
        {
            scanner = new Scanner(System.in);
            String f1 = scanner.nextLine();
            String f2 = scanner.nextLine();
            reader = new BufferedReader(new FileReader(new File(f1)));
            List<Integer> list = new ArrayList<>();
            int count = 1;
            while (reader.ready()){
                int a = reader.read();
                if (count % 2 == 0)
                {
                    list.add(a);
                }
                count++;
            }

            bw = new BufferedWriter(new FileWriter(f2));
            for (Integer i: list)
            {
                bw.write(i);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        finally
        {
            if (scanner != null)
                scanner.close();
            if (reader != null)
                try
                {
                    reader.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            if (bw != null){
                try
                {
                    bw.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
