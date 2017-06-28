package com.javarush.test.level15.lesson12.home04;

/**
 * Created by set on 28.06.17.
 */
public class Sun implements Planet
{
    private static  Sun sun;
    private Sun(){}

    public static Sun getInstance()
    {
        if(sun == null)
        {
            sun = new Sun();
        }
        return sun;
    }
}
