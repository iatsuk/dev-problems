package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String o1 = "Lion.avi.part1";
        System.out.println(o1.substring(0, o1.indexOf(".part")));
        Set<String> parts = new TreeSet<>(new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                return Integer.parseInt(o1.substring(o1.indexOf(".part")+5)) - Integer.parseInt(o2.substring(o2.indexOf(".part")+5));
            }
        });

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        String outFileName = fileName.substring(0, fileName.indexOf(".part"));
        while (!fileName.equals("end")) {
            parts.add(fileName);
            fileName = reader.readLine();
        }
        reader.close();

        FileOutputStream fos = new FileOutputStream(outFileName);
        for (String part : parts) {
            FileInputStream fis = new FileInputStream(part);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fos.write(buffer);
            fis.close();
        }
        fos.close();
    }
}
