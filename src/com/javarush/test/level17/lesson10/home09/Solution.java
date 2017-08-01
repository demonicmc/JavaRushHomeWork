package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String name1 = scanner.nextLine();
        String name2 = scanner.nextLine();

        Scanner fileName = null;
        Scanner fileName2 = null;
        try
        {
            fileName = new Scanner(new File(name1));
            fileName2 = new Scanner(new File(name2));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        while (fileName.hasNext())
        {
            allLines.add(fileName.nextLine());
        }

       while (fileName2.hasNext())
       {
           forRemoveLines.add(fileName2.nextLine());
       }

       try
       {
           Solution solution = new Solution();
           solution.joinData();
       } catch (CorruptedDataException e){
           System.out.println("CorruptedDataException");
       }


    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
