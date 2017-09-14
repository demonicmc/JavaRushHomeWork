package com.javarush.test.level18.lesson03.task05;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.*;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try(Scanner scanner = new Scanner(System.in);
            FileReader reader = new FileReader(scanner.nextLine()))
        {
           Set<Integer> set = new LinkedHashSet<>();
            int b;

            while ((b = reader.read()) != -1)
            {
               set.add(b);
            }
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            for (Integer i:
                 list)
            {
                System.out.print(i + " ");
            }
        }
    }

}
