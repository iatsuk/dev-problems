package com.javarush.test.level14.lesson06.home01;

public class RussianHen extends Hen {

    @Override
    public int getCountOfEggsPerMonth()
    {
        return 30;
    }

    public String getDescription() {
        String result = super.getDescription();

        result += " Моя страна - " + Country.RUSSIA + ". Я несу "+ getCountOfEggsPerMonth() +" яиц в месяц.";

        return result;
    }
}