package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        try{
            Scanner scanner = new Scanner(System.in);
            String f1 = scanner.nextLine();
            String f2 = scanner.nextLine();

            scanner.close();

            BufferedReader reader = new BufferedReader(new FileReader(f1));
            FileWriter fw = new FileWriter(f2);
            String s = null;
            while ((s = reader.readLine()) != null){
                String mas[] = s.split(" ");
                for (int i = 0; i < mas.length; i++) {
                    fw.write(String.valueOf(Math.round(Double.parseDouble(mas[i]))+ " "));
                }
            }
            fw.close();
            reader.close();

//            Writer wr = new FileWriter("/home/set/Загрузки/JavaRushHomeWork (1)/JavaRushHomeWork/src/double.txt");
//
//            Random random = new Random(10);
//            for (int i = 0; i < 10; i++) {
//
//                double d = random.nextDouble();
//                wr.write(String.format("%.2f", d) + " ");
//            }
//            wr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
