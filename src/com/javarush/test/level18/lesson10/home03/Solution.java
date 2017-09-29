package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try
        {
            Scanner scanner = new Scanner(System.in);
            String f1 = scanner.nextLine();
            String f2 = scanner.nextLine();
            String f3 = scanner.nextLine();

            scanner.close();

            FileWriter fw = new FileWriter(f1, true);
            FileReader r1 = new FileReader(f2);
            FileReader r2 = new FileReader(f3);

            while (r1.ready())
                fw.write(r1.read());
            while (r2.ready())
                fw.write(r2.read());

            fw.close();
            r1.close();
            r2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
