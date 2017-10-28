package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String f = scanner.nextLine();
        scanner.close();
        BufferedReader reader;
        List<String> list =new ArrayList<>();

        try{
            reader = new BufferedReader(new FileReader(new File(f)));
            while (reader.ready()){
                list.add(reader.readLine());
            }
            reader.close();

            int count = 0;
            Pattern p = Pattern.compile("\\bworld\\b", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
            Matcher m = null;
            for(String s : list){
                m = p.matcher(s);
                while (m.find()){
                    count++;
                }
            }
            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
