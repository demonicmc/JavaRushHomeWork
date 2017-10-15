package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        try{ //Считали с консоли имя файла
            List<String> list = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fname = reader.readLine();
            reader.close();

            if (args[0].equals("-u")){
                BufferedReader r = new BufferedReader(new FileReader(fname));
                while (r.ready()){
                    list.add(r.readLine());
                }
                r.close();
                String productname = args[2];
//                for (int i = 3; i < args.length-2; i++){
//                    productname += " " + args[i];
//                }

                int id = Integer.parseInt(args[1].trim());
                for (int i = 0 ; i < list.size(); i++){
                    String s = list.get(i).substring(0,8).replaceAll(" ", "");
                    int j = Integer.parseInt(s);
                    if (id == j){
                        list.set(i, String.format("%-8.8s%-30.30s%-8.8s%-4.4s",String.valueOf(j),productname,args[args.length-2],args[args.length-1]));
                    }
                }
                BufferedWriter bw = new BufferedWriter(new FileWriter(fname));
                for (int i = 0; i < list.size(); i++){
                    if (list.get(i).equals("")) continue;
                    bw.write(String.format("%s%n", list.get(i)));
                }
                bw.close();
            }
            else if (args[0].equals("-d")){
                BufferedReader r = new BufferedReader(new FileReader(fname));
                while (r.ready()){
                    list.add(r.readLine());
                }
                r.close();

                int id = Integer.parseInt(args[1].trim());
                for (int i = 0 ; i < list.size(); i++){
                    String s = list.get(i).substring(0,8).replaceAll(" ", "");
                    int j = Integer.parseInt(s);
                    if (id == j){
                        list.remove(i);
                    }
                }
                BufferedWriter bw = new BufferedWriter(new FileWriter(fname));
                for (int i = 0; i < list.size(); i++){
                    if (list.get(i).equals("")) continue;
                    bw.write(String.format("%s%n", list.get(i)));
                }
                bw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
