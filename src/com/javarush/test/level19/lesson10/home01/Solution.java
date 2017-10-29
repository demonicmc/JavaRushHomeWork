package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {

        try
        {
            File f = new File(args[0]);

            Scanner sc = new Scanner(f);
            Map<String, Double> map = new TreeMap<>();
            List<String> list = new ArrayList<>();
            String[] arr = null;

            while (sc.hasNext()){
                arr = sc.nextLine().split(" ");
                if (map.containsKey(arr[0])){
                    map.put(arr[0], Double.parseDouble(arr[1]) + map.get(arr[0]));
                } else
                    map.put(arr[0], Double.parseDouble(arr[1]));
            }
            sc.close();

            for (Map.Entry<String, Double>  m : map.entrySet()){
                String k = m.getKey();
                Double v = m.getValue();
                System.out.println(k + " " + v);
            }


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
