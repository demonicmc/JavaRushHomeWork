package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
   public Solution(){}
   public Solution(String s){}
    public Solution(String s, int a){}

     Solution(int a){}
     Solution(int a, int b){}
     Solution(int c, String a){}

    private Solution(String s, int a, int b){}
    private Solution(int g, String a, String b){}
    private Solution(String s, String c){}

    protected Solution(double a){}
    protected Solution(double a, int b){}
    protected Solution(String s, double a){}


}

