package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String f1 = scanner.nextLine();
        String f2 = scanner.nextLine();

        try
        {
            BufferedReader r = new BufferedReader(new FileReader(new File(f1)));
            List<String> list = new ArrayList<>();
            while (r.ready()){
                list.add(r.readLine());
            }
            String[] numb = null;
            List<String> list1 = new ArrayList<>();
           for (int i = 0; i < list.size(); i++){
               numb = list.get(i).split(" ");
              for (int j = 0; j < numb.length; j++){
                  if (isNumeric(numb[j])){
                      list1.add(numb[j]);
                  }
              }
           }

            System.out.println(list1);
            BufferedWriter bw = new BufferedWriter(new FileWriter(f2));
            for (int i = 0; i < list1.size(); i++){
                bw.write(list1.get(i));
                bw.write(" ");
            }

            scanner.close();
            r.close();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean isNumeric(String str)
    {
        return str.matches("[-+]?\\d+");  //match a number with optional '-' and decimal.
    }
}
