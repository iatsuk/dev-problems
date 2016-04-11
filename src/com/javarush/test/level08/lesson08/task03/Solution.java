package com.javarush.test.level08.lesson08.task03;

import java.util.*;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //Напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("1", "1");
        map.put("2", "1");
        map.put("3", "2");
        map.put("4", "3");
        map.put("5", "4");
        map.put("6", "4");
        map.put("7", "4");
        map.put("8", "5");
        map.put("9", "6");
        map.put("10","7");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //Напишите тут ваш код
        int k = 0;
        for (Map.Entry<String, String> pair : map.entrySet())
            if (pair.getValue().equals(name)) k++;
        return k;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        //Напишите тут ваш код
        int k = 0;
        for (Map.Entry<String, String> pair : map.entrySet())
            if (pair.getKey().equals(familiya)) k++;
        return k;
    }
}
