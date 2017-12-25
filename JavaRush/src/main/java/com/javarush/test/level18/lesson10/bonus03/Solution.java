package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        fis.close();

        String data = new String(buffer);
        String[] lines = data.split("\n");

        switch (args[0])
        {
            case "-u":
                for (int i = 0; i < lines.length; i++)
                {
                    if (lines[i].substring(0, 8).trim().equals(args[1]))
                    {
                        String line = args[1];
                        line = setLength(line, 8) + args[2];
                        line = setLength(line, 38) + args[3];
                        line = setLength(line, 46) + args[4];
                        line = setLength(line, 50);
                        lines[i] = line;
                    }
                }
                break;
            case "-d":
                for (int i = 0; i < lines.length; i++)
                    if (lines[i].substring(0, 8).trim().equals(args[1]))
                        lines[i] = "";
                break;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String line : lines)
        {
            if (!line.equals(""))
            {
                stringBuilder.append(line).append("\n");
            }
        }

        FileOutputStream fos = new FileOutputStream(file);
        fos.write(stringBuilder.toString().getBytes());
        fos.close();
    }

    private static String setLength(String str, int newLength)
    {
        char[] chrs;
        if (str.length() < newLength) {
            chrs = new char[newLength];
            for (int i = 0; i < str.length(); i++) chrs[i] = str.toCharArray()[i];
            Arrays.fill(chrs, str.length(), newLength, ' ');
        } else {
            chrs = str.substring(0, newLength).toCharArray();
        }
        return new String(chrs);
    }
}
