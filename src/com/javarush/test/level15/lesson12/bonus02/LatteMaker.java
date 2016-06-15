package com.javarush.test.level15.lesson12.bonus02;

public class LatteMaker extends DrinkMaker
{
    @Override
    protected void getRightCup()
    {
        System.out.println("Берем чашку для латте");
    }

    @Override
    protected void putIngredient()
    {
        System.out.println("Делаем кофе");
    }

    @Override
    protected void pour()
    {
        System.out.println("Заливаем молоком с пенкой");
    }
}
