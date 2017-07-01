package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by set on 01.07.17.
 */
public abstract class DrinkMaker
{
    abstract void getRightCup();
    abstract void putIngredient();
    abstract void pour();

    void makeDrink()
    {
        getRightCup();
        putIngredient();
        pour();
    }
}
