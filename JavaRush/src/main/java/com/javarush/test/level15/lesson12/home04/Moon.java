package com.javarush.test.level15.lesson12.home04;

public final class Moon implements Planet
{
    private static Moon _instance = null;

    public static synchronized Moon getInstance()
    {
        if (_instance == null) {
            _instance = new Moon();
        }
        return _instance;
    }

    private Moon()
    {
    }
}
