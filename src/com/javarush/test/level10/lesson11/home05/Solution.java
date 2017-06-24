package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
д 0
…
я 9
*/

public class Solution
{

    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();


        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++)
        {
            alphabet.add(abcArray[i]);
        }

        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
        {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        int[] mas = new int[abc.length()];

        //напишите тут ваш код
        for (int i = 0; i<10; i++){
            char[] ch = list.get(i).toCharArray();
            for (int j = 0; j<ch.length; j++){
                for (int k = 0; k<abc.length(); k++){
                    if (ch[j] == abcArray[k]){
                        map.put(ch[j],++mas[k]);
                    } else if(!map.containsKey(abcArray[k])){
                        map.put(abcArray[k], 0);
                    }
                }
            }
        }
        for (Map.Entry<Character, Integer> m: map.entrySet())
        {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }

}
