package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        //Напишите тут ваш код
        HashSet<String> set = new HashSet<String>();
        set.add("Люкс");
        set.add("Люксембург");
        set.add("Ломаносов");
        set.add("Лимон");
        set.add("Лайм");

        set.add("Лампочка");
        set.add("Лампа");
        set.add("Лилипут");
        set.add("Лирика");
        set.add("ЛОР");

        set.add("Лопасть");
        set.add("Ласка");
        set.add("Личинка");
        set.add("Лич");
        set.add("Личина");

        set.add("Ландыш");
        set.add("Липа");
        set.add("Лом");
        set.add("Лоск");
        set.add("Ляп");
        return set;
    }
}
