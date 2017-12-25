package com.javarush.test.level15.lesson12.home04;

public final class Sun implements Planet
{
    private static Sun _instance = null;

    public static synchronized Sun getInstance()
    {
        if (_instance == null) {
            _instance = new Sun();
        }
        return _instance;
    }

    private Sun()
    {
    }
}
