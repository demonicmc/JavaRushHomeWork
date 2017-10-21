package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = null;
        BufferedReader r = null;
        BufferedWriter bw = null;
        try
        {
            scanner = new Scanner(System.in);
            String f1 = scanner.nextLine();
            String f2 = scanner.nextLine();

            r = new BufferedReader(new FileReader(new File(f1)));
            bw = new BufferedWriter(new FileWriter(new File(f2)));
            List<String> list = new ArrayList<>();
            while (r.ready()){
                list.add(r.readLine().replaceAll("\\p{Punct}", ""));
            }

            for (String s : list) {
                bw.write(s);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        finally
        {
            if (scanner != null) scanner.close();
            if (r != null) try
            {
                r.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            if (bw != null) try
            {
                bw.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
