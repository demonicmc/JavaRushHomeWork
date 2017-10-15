package com.javarush.test.level19.lesson03.task04;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{

        private Scanner sc;
        public PersonScannerAdapter(Scanner scanner){
            sc = scanner;
        }

        @Override
        public Person read() throws IOException
        {
            String[] person = sc.nextLine().split(" ");
            String date = person[3] + " " + person[4] + " " + person[5];

            Date d = null;
            try
            {
                d = new SimpleDateFormat("dd MM yyyy").parse(date);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }

            Person p = new Person(person[1], person[2], person[0],
                    d);
            return p;
        }

        @Override
        public void close() throws IOException
        {
            sc.close();
        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(new File("/home/set/Загрузки/JavaRushHomeWork (1)/JavaRushHomeWork/1.txt"));
        PersonScannerAdapter psa = new PersonScannerAdapter(scanner);
        Person p = psa.read();
        psa.close();
        System.out.println(p);
    }

}
