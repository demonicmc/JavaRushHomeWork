package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {
        //start here - начни тут
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
        SimpleDateFormat inDayFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        if("-c".equals(args[0])){
            if ("м".equals(args[2]))
            {
                allPeople.add(Person.createMale(args[1], inDayFormat.parse(args[3])));
            } else
            {
                allPeople.add(Person.createFemale(args[1], inDayFormat.parse(args[3])));
            }
            System.out.println(allPeople.size() - 1);
        }
        if("-u".equals(args[0])){
            allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
            allPeople.get(Integer.parseInt(args[1])).setSex(setSexPeople(args[3]));
            allPeople.get(Integer.parseInt(args[1])).setBirthDay(inDayFormat.parse(args[4]));
        }
        if("-d".equals(args[0])){
            allPeople.get(Integer.parseInt(args[1])).setName(null);
            allPeople.get(Integer.parseInt(args[1])).setSex(null);
            allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);
        }
        if("-i".equals(args[0])){
            System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " "
                    + sexPeople(allPeople.get(Integer.parseInt(args[1])).getSex())
                    + " " + dayFormat.format(allPeople.get(Integer.parseInt(args[1])).getBirthDay()));
        }
    }

    private static String sexPeople(Sex sex){
        if(sex == Sex.FEMALE){
            return "ж";
        }
        if(sex == Sex.MALE){
            return "м";
        }
        return "";
    }
    private static Sex setSexPeople(String sex){
        return "м".equals(sex)?Sex.MALE:Sex.FEMALE;
    }

}
