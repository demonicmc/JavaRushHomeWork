package com.javarush.test.level18.lesson03.task02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try(Scanner scanner = new Scanner(System.in);
                    FileReader reader = new FileReader(new File(scanner.nextLine())))
        {
            List<Integer> list = new ArrayList<>();
            int c;
            while ((c = reader.read()) != -1)
            {
                list.add(c);
            }
            Collections.sort(list);
            System.out.println(list.get(0));
        }
    }
}
