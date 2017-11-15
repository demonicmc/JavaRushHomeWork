package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        BufferedReader r = null;
        BufferedReader reader = null;
        BufferedReader bufferedReader = null;

        try
        {
            r = new BufferedReader(new InputStreamReader(System.in));
            String f = r.readLine();
            String f2 = r.readLine();

            reader = new BufferedReader(new FileReader(f));
            bufferedReader = new BufferedReader(new FileReader(f2));

            List<String> list = new ArrayList<>();
            List<String > stringList = new ArrayList<>();

            while (reader.ready()){
                list.add(reader.readLine());
            }
            while (bufferedReader.ready()){
                stringList.add(bufferedReader.readLine());
            }

            while (!list.isEmpty() | !stringList.isEmpty()) {
                if (stringList.isEmpty()) {
                    lines.add(new LineItem(Type.REMOVED, list.get(0)));
                    list.remove(0);
                }else if (list.isEmpty()) {
                    lines.add(new LineItem(Type.ADDED, stringList.get(0)));
                    stringList.remove(0);
                }else if (list.get(0).equals(stringList.get(0))) {
                    lines.add(new LineItem(Type.SAME, list.get(0)));
                    list.remove(0);
                    stringList.remove(0);
                } else if (list.get(0).equals(stringList.get(1))) {
                    lines.add(new LineItem(Type.ADDED, stringList.get(0)));
                    stringList.remove(0);
                } else {
                    lines.add(new LineItem(Type.REMOVED, list.get(0)));
                    list.remove(0);
                }
            }

            for (LineItem it : lines)
            {
                System.out.println(it);
            }
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

            if (reader != null) try
            {
                reader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            if (bufferedReader != null) try
            {
                bufferedReader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString()
        {
            return
                     type + " " + line;
        }
    }
}
