package com.javarush.test.level18.lesson05.task05;

/* DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки
2.2 выбросить исключение DownloadException
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws DownloadException {
            Scanner sc = new Scanner(System.in);
            String r;
            File f;
            while (true)
            {
                r = sc.nextLine();
                f = new File(r);
                if (f.length() < 1000)
                {
                    sc.close();
                    throw new DownloadException();
                }
            }

    }

    public static class DownloadException extends Exception{

    }
}
