package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String params = reader.readLine();
        reader.close();

        params = params.substring(params.indexOf("?")+1);
        String[] params2 = params.split("&");
        Map<String, String> params3 = new LinkedHashMap<>();
        for (String param : params2) {
            String[] buf = param.split("=");
            System.out.print(buf[0] + " ");
            if (buf.length > 1)
            {
                params3.put(buf[0], buf[1]);
            } else {
                params3.put(buf[0], null);
            }
        }
        System.out.println();
        for (Map.Entry<String, String> entry : params3.entrySet()) {
            if (entry.getKey().equals("obj")) {
                try
                {
                    alert(Double.parseDouble(entry.getValue()));
                } catch (Exception e) {
                    alert(entry.getValue());
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
