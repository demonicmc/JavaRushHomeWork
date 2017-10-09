package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = null;
        BufferedReader reader = null;
        try
        {
            scanner = new Scanner(System.in);
            reader = new BufferedReader(new FileReader(scanner.nextLine()));
            String con[] = null;
            String s = "";

            while ((s = reader.readLine()) != null){
                con = s.split(" ");
                if (con[0].equals(args[0])) {
                    System.out.println(s);
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
            if (scanner != null) scanner.close();
            if (reader != null) try
            {
                reader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
