package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        Map<Integer, Integer> byteCount = new HashMap<>();
        int maxRepeat = 0;
        while (fis.available() > 0) {
            int data = fis.read();
            if (byteCount.containsKey(data)) {
                int rep = byteCount.remove(data);
                byteCount.put(data, rep + 1);
                if (maxRepeat < rep + 1) maxRepeat = rep + 1;
            } else {
                byteCount.put(data, 1);
                if (maxRepeat == 0) maxRepeat = 1;
            }
        }
        fis.close();
        for (Map.Entry<Integer, Integer> entry : byteCount.entrySet()) {
            if (entry.getValue() == maxRepeat) System.out.print(entry.getKey() + " ");
        }
    }
}
