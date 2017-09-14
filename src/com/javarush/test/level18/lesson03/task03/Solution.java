package com.javarush.test.level18.lesson03.task03;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.*;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try(Scanner scanner = new Scanner(System.in);
                    FileReader reader = new FileReader(scanner.nextLine()))
        {
            List<Integer> list = new ArrayList<>();
            int b;

            while ((b = reader.read()) != -1)
            {
                list.add(b);
            }
            Integer[] mas = new Integer[list.size()];
            Arrays.fill(mas, 0);
            for (int i = 0; i<list.size(); i++)
            {

                for (int j = 0; j<list.size(); j++)
                {
                    if (list.get(i).equals(list.get(j)))
                    {
                        mas[i] = addIn(mas[i]);
                    }
                }
            }
//            for (Integer i:
//                 mas)
//            {
//                System.out.print(i + " ");
//            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i<mas.length; i++)
            {
               map.put(list.get(i), mas[i]);
            }
            Arrays.sort(mas);
            List<Integer> l = new ArrayList<>();
            for (Map.Entry<Integer, Integer> m : map.entrySet())
            {
                Integer num = m.getValue();
                Integer key = m.getKey();
                if (num.equals(mas[mas.length-1]))
                {
                    l.add(key);
                }
            }
            for (Integer i:
                 l)
            {
                System.out.print(i + " ");
            }
        }
    }
    public static int addIn (int i)
    {
        return ++i;
    }

}
