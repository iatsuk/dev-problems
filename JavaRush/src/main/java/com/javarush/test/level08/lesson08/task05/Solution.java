package com.javarush.test.level08.lesson08.task05;

import java.util.*;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //Напишите тут ваш код
        ArrayList<String> names = new ArrayList<String>();
        HashSet<String> rem = new HashSet<String>();

        for (Map.Entry<String, String> pair: map.entrySet()) {
            if (!names.contains(pair.getValue())) {
                names.add(pair.getValue());
            } else {
                rem.add(pair.getValue());
            }
        }

        for (String val: rem) {
            removeItemFromMapByValue(map, val);
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
