package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name, filename;
        ArrayList<String> str = new ArrayList<>();
        name = reader.readLine();
        while(!"end".equals(name)){
            str.add(name);
            name = reader.readLine();
        }
        Collections.sort(str);
        for (int i = 0; i < str.size(); i++)
        {
            System.out.println(str.get(i));
        }
        FileWriter fWriter = new FileWriter(str.get(0).substring(0, str.get(0).indexOf(".part")));
        BufferedReader fReader;
        for (int i = 0; i < str.size(); i++)
        {
            fReader = new BufferedReader(new FileReader(str.get(i)));
            while(fReader.ready()){
                String data = fReader.readLine();
                if(i == 0){
                    fWriter.write(data);
                }else{
                    fWriter.append(data);
                }
            }
        }

        fWriter.close();

    }
}