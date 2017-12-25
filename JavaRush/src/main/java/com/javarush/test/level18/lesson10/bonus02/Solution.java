package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

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

public class Solution
{
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
        int id = Integer.parseInt(lines[lines.length - 1].substring(0, 8).trim()) + 1;

        String line = String.valueOf(id);
        line = setLength(line, 8) + args[1];
        line = setLength(line, 38) + args[2];
        line = setLength(line, 46) + args[3];
        line = setLength(line, 50);
        data = data + "\n" + line;


        FileOutputStream fos = new FileOutputStream(file);
        fos.write(data.getBytes());
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