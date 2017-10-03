package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(System.in);
            String f1 = scanner.nextLine();
            String f2 = scanner.nextLine();
            scanner.close();

            RandomAccessFile ras = new RandomAccessFile(f1, "rw");
            RandomAccessFile rf = new RandomAccessFile(f2, "r");
            byte[] buf = new byte[(int)ras.length()];
            byte[] bu = new byte[(int)rf.length()];
            ras.read(buf);
            rf.read(bu);

            ras.seek(0);
            ras.write(bu);
            ras.write(buf);

            ras.close();
            rf.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
