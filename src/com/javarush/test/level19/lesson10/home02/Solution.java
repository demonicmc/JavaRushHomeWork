package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.File;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = null;
        try
        {
            File f = new File(args[0]);
            List<String> maximum = new ArrayList<>();
            sc = new Scanner(f);
            Map<String, Double> map = new TreeMap<>();
            String[] arr = null;

            while (sc.hasNext()){
                arr = sc.nextLine().split(" ");
                if (map.containsKey(arr[0])){
                    map.put(arr[0], Double.parseDouble(arr[1]) + map.get(arr[0]));
                } else
                    map.put(arr[0], Double.parseDouble(arr[1]));
            }


            double max = 0;
            for (Map.Entry<String, Double>  m : map.entrySet()){
                Double v = m.getValue();
                if (max < v){
                    max = v;
                }
            }
            for (Map.Entry<String, Double>  m : map.entrySet()){
                String k = m.getKey();
                Double v= m.getValue();
                if (v == max){
                    maximum.add(k);
                }
            }
            for (String s: maximum)
            {
                System.out.println(s);
            }



        } catch (Exception e){
            e.printStackTrace();
        } finally
        {
            sc.close();
        }
    }
}
