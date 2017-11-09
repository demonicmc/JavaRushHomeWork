package com.javarush.test.level19.lesson10.home06;

import java.io.*;
import java.util.*;


/* Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла
3. Заменить все числа на слова используя словарь map
4. Результат вывести на экран
5. Закрыть потоки. Не использовать try-with-resources

Пример данных:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

public class Solution
{
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static
    {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args)
    {
        try
        {
            Scanner sc = new Scanner(System.in);
            String f = sc.nextLine();
            BufferedReader r = new BufferedReader(new FileReader(f));

            List<String> list = new ArrayList<>();
            String[] str = null;
            String s = "";


            while ((s = r.readLine()) != null){
                String n = "";
                str = s.split(" ");
                for (int i = 0; i < str.length; i ++){
                    for(Map.Entry<Integer, String> m : map.entrySet()){
                        Integer k = m.getKey();
                        String v = m.getValue();

                        if (String.valueOf(k).equals(str[i])){
                            str[i] = v;
                        }
                    }
                    n += str[i] + " ";
                }
                list.add(n);
            }

            for(String l : list){
                System.out.println(l.trim());
            }

            r.close();
            sc.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
