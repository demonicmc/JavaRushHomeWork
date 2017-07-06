package com.javarush.test.level15.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by set on 06.07.17.
 */
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        if (n<0) return "0";
        else  if (n == 0) return "1";
        BigInteger result = BigInteger.valueOf(1);
        int i = 1;
//        String tmp[] = new String[n];
        for (; i<n+1; i++)
        {
            result = result.multiply(BigInteger.valueOf(i));
//            tmp[i-1] = String.valueOf(i);
        }

//        String res = n + "!" + " " + "= " + "factorial(" + n + ")" + " = ";
//        for (String str:tmp)
//        {
//            res = res + str + "*";
//        }
//        String end = res.substring(0,res.length()-1) + " = " + result;

        return result.toString();
    }
}
