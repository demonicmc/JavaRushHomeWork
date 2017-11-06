package com.javarush.test.level19.lesson10.home05;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/
public class Solution
{
        public static void main(String[] args) {
            BufferedReader r = null;
            BufferedWriter w = null;
            Pattern p = Pattern.compile("\\b.*\\d.*\\b");
            Matcher m = null;
            try
            {
                r = new BufferedReader(new FileReader(new File(args[0])));
                w = new BufferedWriter(new FileWriter(args[1]));
                while (r.ready()){
                    String str[] = r.readLine().split(" ");
                    for (String s : str){
                        m = p.matcher(s);
                        if (m.find()){
                            w.write(m.group() + " ");
                        }
                    }
                }
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
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
                if (w != null) try
                {
                    w.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
