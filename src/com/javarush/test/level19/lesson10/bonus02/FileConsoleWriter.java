package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.*;

public class FileConsoleWriter extends FileWriter
{
    public static void main(String[] args) throws IOException
    {
        FileConsoleWriter fileConsoleWriter = new FileConsoleWriter(new File("/home/set/3.txt"));
        fileConsoleWriter.write("123456789".toCharArray(), 2, 5);
        fileConsoleWriter.write("123456789");
        fileConsoleWriter.write(9999);
        fileConsoleWriter.write("qwertyu", 2, 5);
        fileConsoleWriter.write("dfghj".toCharArray());

        fileConsoleWriter.flush();
        fileConsoleWriter.close();
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException
    {
        super(fileName, append);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException
    {
        super(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd)
    {
        super(fd);
    }

    public FileConsoleWriter(String fileName) throws IOException
    {
        super(fileName);
    }

    public FileConsoleWriter(File file) throws IOException
    {
        super(file);
    }

    @Override
    public void write(String str, int off, int len) throws IOException
    {
        String tmp = "";
        char[] cbuf = str.toCharArray();
        if (len != 0){
            for (int i = off; i < len + off; i++){
                tmp += cbuf[i];
            }
        } else {
            for (int i = off; i < cbuf.length; i++){
                tmp += cbuf[i];
            }
        }
        System.out.println(tmp);

        super.write(str, off, len);
    }

    @Override
    public void flush() throws IOException
    {
        super.flush();
    }

    @Override
    public void close() throws IOException
    {
        super.close();
    }


    @Override
    public void write(String str) throws IOException
    {
        System.out.println(str.substring(0, str.length()));

        super.write(str, 0, str.length());

    }

    @Override
    public void write(int c) throws IOException
    {
        System.out.println((char) c);

        super.write(c);

    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException
    {
        String tmp = "";
       if (len != 0){
           for (int i = off; i < len + off; i++){
               tmp += cbuf[i];
           }
       } else {
           for (int i = off; i < cbuf.length; i++){
               tmp += cbuf[i];
           }
       }
        System.out.println(tmp);

        super.write(cbuf, off, len);
    }

    @Override
    public void write(char[] cbuf) throws IOException
    {
        String tmp = "";
        for (char ch : cbuf)
            tmp += ch;

        System.out.println(tmp);

        super.write(cbuf, 0, cbuf.length);
    }
}
