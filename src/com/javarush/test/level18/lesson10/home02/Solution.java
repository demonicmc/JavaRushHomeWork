package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try
        {
            FileReader reader = new FileReader(new File(args[0]));
            float count = 0f;
            float countSpace = 0f;
            int i = 0;
            while ((i = reader.read()) != -1){
                count++;
                if (String.valueOf((char)i).equals(" ")){
                    countSpace++;
                }
            }
            reader.close();
            System.out.printf("%.2f", countSpace/count * 100);

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
