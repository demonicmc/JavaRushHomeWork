package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;


public class Solution {
    public static void main(String[] args) {
        try
        {
            FileReader reader = new FileReader(args[0]);
            Map<Character, Integer> map = new TreeMap<>();
//            String symbol = null;
            int symb = 0;
            while ((symb = reader.read()) != -1) {
                if (map.containsKey((char)symb)){
                    map.put((char)symb,
                            addIncrement(map.get((char)symb)));
                } else {
                    map.put((char)symb, addIncrement(0));
                }
            }
            reader.close();

            for (Map.Entry<Character, Integer> m:
                    map.entrySet())
            {
                System.out.println(m.getKey() + " " + m.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int addIncrement (int a) {
        a = a + 1;
        return a;
    }
}
