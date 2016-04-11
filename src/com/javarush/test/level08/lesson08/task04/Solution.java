package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JUN 1 1980"));
        map.put("Сталлонq", new Date("JUL 1 1980"));
        map.put("Сталлонa", new Date("JAN 1 1980"));
        map.put("Сталлонz", new Date("FEB 1 1980"));
        map.put("Сталлонw", new Date("MAR 1 1980"));
        map.put("Сталлонs", new Date("APR 1 1980"));
        map.put("Сталлонx", new Date("MAY 1 1980"));
        map.put("Сталлонe", new Date("AUG 1 1980"));
        map.put("Сталлонd", new Date("OCT 1 1980"));
        map.put("Сталлонc", new Date("NOV 1 1980"));
        //Напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //Напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            int month = iterator.next().getValue().getMonth() + 1;
            if (6 <= month && month <= 8)
            {
                iterator.remove();
            }
        }
    }
}
