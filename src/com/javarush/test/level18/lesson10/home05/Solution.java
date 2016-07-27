package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        FileOutputStream fos = new FileOutputStream(reader.readLine());
        reader.close();

        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        fis.close();

        String parsed = new String(buffer);
        String[] data = parsed.split(" ");

        int[] rounded = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            rounded[i] = (int) Math.round(Double.parseDouble(data[i]));
        }

        StringBuilder result = new StringBuilder();
        for (int value : rounded) {
            result.append(value).append(" ");
        }

        fos.write(result.toString().getBytes());
        fos.close();
    }
}
