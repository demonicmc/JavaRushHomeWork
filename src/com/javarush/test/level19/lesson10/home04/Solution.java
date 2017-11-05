package com.javarush.test.level19.lesson10.home04;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution
{
    public static List<String> words = new ArrayList<String>();

    static
    {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args)
    {
        BufferedReader r = null;
        BufferedReader reader = null;

        try
        {
            r = new BufferedReader(new InputStreamReader(System.in));
            String f = r.readLine();
            reader = new BufferedReader(new FileReader(f));

            while (reader.ready()){
                String name = reader.readLine();
                String str[] = name.split(" ");
                Map<String, Integer> map = new HashMap<>();

                for (int i = 0; i < str.length; i++){
                    for (String s : words){
                        if (s.equals(str[i])){
                            map.put(str[i], 1);
                        }
                    }
                }
                if (map.size() == 2){
                    System.out.println(name);
                }
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (r != null) {
                try
                {
                    r.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try
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
}
