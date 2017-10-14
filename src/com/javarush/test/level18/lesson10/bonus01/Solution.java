package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        try
        {
            FileInputStream fis = fis = new FileInputStream(args[1]);
            FileOutputStream fos = fos = new FileOutputStream(args[2]);
            int sh = 0;

            if(args[0].contains("-e")) {

                while (fis.available() > 0) {
                    sh = fis.read()^1;
                    fos.write(sh);
                }
            } else if (args[0].contains("-d")) {
                while (fis.available() > 0) {
                    sh = fis.read()^1;
                    fos.write(sh);
                }
            }
            fis.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
