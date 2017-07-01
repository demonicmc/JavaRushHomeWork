package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by set on 01.07.17.
 */
public class LatteMaker extends DrinkMaker
{
    @Override
    void getRightCup()
    {
        System.out.println("Берем чашку для латте");
    }

    @Override
    void putIngredient()
    {
        System.out.println("Делаем кофе");
    }

    @Override
    void pour()
    {
        System.out.println("Заливаем молоком с пенкой");

    }

    @Override
    void makeDrink()
    {
        super.makeDrink();
    }
}
