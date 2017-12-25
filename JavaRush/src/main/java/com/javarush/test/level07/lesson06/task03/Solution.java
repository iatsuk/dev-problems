package com.javarush.test.level07.lesson06.task03;

/* 5 строчек в обратном порядке
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в него.
3. Расположи их в обратном порядке.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 5; i++)
            list.add(reader.readLine());
        for (int i = 0; i < list.size() / 2; i++)
        {
            String c = list.get(i);
            list.set(i, list.get(list.size()-1-i));
            list.set(list.size()-1-i, c);
        }
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}
