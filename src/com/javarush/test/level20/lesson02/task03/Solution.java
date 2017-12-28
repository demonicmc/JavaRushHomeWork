package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        Scanner sc = new Scanner(System.in);
        try
        {
            FileInputStream fis = new FileInputStream(sc.nextLine());
            load(fis);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties properti = new Properties();
        for (Map.Entry<String, String> m : properties.entrySet()) {
            properti.setProperty(m.getKey(), m.getValue());
            System.out.println(m.getKey() + " " + m.getValue());
        }
        OutputStream output = outputStream;
        properti.store(output, null);

    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        InputStream input = inputStream;
        Properties properti = new Properties();
        properti.load(input);

        for (Map.Entry<Object, Object> m : properti.entrySet()) {
            properties.put((String)m.getKey(), (String)m.getValue());
//            System.out.println(m.getKey() + " " + m.getValue());
        }
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        solution.fillInPropertiesMap();
    }
}
