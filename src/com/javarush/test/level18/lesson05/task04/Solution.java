package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try
        {
            Scanner scanner1 = new Scanner(System.in);
            String f1 = scanner1.nextLine();
            String f2 = scanner1.nextLine();

            FileInputStream fis = new FileInputStream(new File(f1));
            FileOutputStream fos = new FileOutputStream(new File(f2));

            scanner1.close();
            byte[] array = new byte[fis.available()];
            int index = 0;
            while (fis.available()>0)
            {
                array[index] = (byte) fis.read();
                index++;
            }
            for (int i = 0; i<array.length; i++)
            {
                fos.write(array[array.length-1-i]);
            }
            fos.close();
            fis.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
