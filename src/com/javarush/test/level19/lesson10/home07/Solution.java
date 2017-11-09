package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        BufferedReader r = null;
        BufferedWriter w = null;

        List<String> list = new ArrayList<>();

        try
        {
            r = new BufferedReader(new FileReader(args[0]));
            w = new BufferedWriter(new FileWriter(args[1]));

            while (r.ready()){
                String[] arr = r.readLine().split(" ");
                for(String s : arr){
                    if (s.length() > 6){
                        list.add(s);
                    }
                }
            }

            for(int i = 0; i < list.size(); i++){
                if (i == list.size() - 1){
                    w.write(list.get(i));
                    break;
                }
                w.write(list.get(i) + ",");
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
            if (r != null) try
            {
                r.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            if (w != null) try
            {
                w.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }
}
