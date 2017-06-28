package com.javarush.test.level15.lesson12.home05;

/**
 * Created by set on 28.06.17.
 */
public class SubSolution extends Solution
{
    public SubSolution()
    {
    }

    public SubSolution(String s)
    {
        super(s);
    }

    public SubSolution(String s, int a)
    {
        super(s, a);
    }



     SubSolution(int a)
    {
        super(a);
    }

     SubSolution(int a, int b)
    {
        super(a, b);
    }

     SubSolution(int c, String a)
    {
        super(c, a);
    }



    protected SubSolution(double a)
    {
        super(a);
    }

    protected SubSolution(double a, int b)
    {
        super(a, b);
    }

   protected SubSolution(String s, double a)
    {
        super(s, a);
    }

    private SubSolution(String s, int a, int b){}
    private SubSolution(int g, String a, String b){}
    private SubSolution(String s, String c){}

}
