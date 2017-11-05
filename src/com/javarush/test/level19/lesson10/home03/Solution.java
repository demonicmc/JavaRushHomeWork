package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        BufferedReader r = null;
        try
        {
            r = new BufferedReader(new FileReader(args[0]));
            String array[] = null;
            Date d = null;

            while (r.ready()){
                array = r.readLine().split(" ");
                String date = array[array.length-3] + " " + array[array.length-2] + " " + array[array.length-1];
                d = new SimpleDateFormat("dd MM yyyy").parse(date);
                String name = "";
                for (int i = 0; i < array.length - 3; i++){
                    name += array[i] + " ";
                }
                Person person = new Person(name.trim(),d);
                PEOPLE.add(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ParseException e)
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
        }
    }
}
