package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fos = new FileOutputStream(reader.readLine());
        FileInputStream fis1 = new FileInputStream(reader.readLine());
        FileInputStream fis2 = new FileInputStream(reader.readLine());

        byte[] buffer = new byte[fis1.available()];
        fis1.read(buffer);
        fos.write(buffer);

        buffer = new byte[fis2.available()];
        fis2.read(buffer);
        fos.write(buffer);

        fos.close();
        fis1.close();
        fis2.close();
        reader.close();
    }
}
