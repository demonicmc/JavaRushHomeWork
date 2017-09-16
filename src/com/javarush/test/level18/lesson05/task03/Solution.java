package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            String file3 = reader.readLine();

            FileInputStream fis = new FileInputStream(new File(file1));
            FileOutputStream fos1 = new FileOutputStream(new File(file2));
            FileOutputStream fos2 = new FileOutputStream(new File(file3));

            byte[] mas = new byte[fis.available()];
            int index =0;
            while (fis.available()>0)
            {
               mas[index] = (byte) fis.read();
               index++;
            }

            if (mas.length%2 == 0)
            {
                byte[] mas1 = new byte[mas.length/2];
                System.arraycopy(mas, 0, mas1, 0, mas.length/2);
                fos1.write(mas1, 0 ,mas1.length);

                byte[] mas2 = new byte[mas.length/2];
                System.arraycopy(mas, mas.length/2-1, mas2, 0, mas2.length);
                fos2.write(mas2, 0 , mas2.length);
            } else
            {
                byte[] mas1 = new byte[mas.length/2 + 1];
                System.arraycopy(mas, 0, mas1, 0, mas1.length);
                fos1.write(mas1, 0 ,mas1.length);

                byte[] mas2 = new byte[mas.length - mas1.length];
                System.arraycopy(mas, mas2.length-1, mas2, 0, mas2.length);
                fos2.write(mas2, 0 ,mas2.length);
            }
            reader.close();
            fis.close();
            fos1.close();
            fos2.close();

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
