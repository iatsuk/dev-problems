package com.javarush.test.level15.lesson12.home04;

public final class Earth implements Planet
{
    private static Earth _instance = null;

    public static synchronized Earth getInstance()
    {
        if (_instance == null) {
            _instance = new Earth();
        }
        return _instance;
    }

    private Earth()
    {
    }
}
