package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        Map<Integer, Integer> byteCount = new HashMap<>();
        while (fis.available() > 0) {
            int data = fis.read();
            if (byteCount.containsKey(data)) {
                int rep = byteCount.remove(data);
                byteCount.put(data, rep + 1);
            } else {
                byteCount.put(data, 1);
            }
        }
        fis.close();
        int minRepeat = Integer.MAX_VALUE;
        for (Integer rep : byteCount.values()) {
            if (minRepeat > rep) minRepeat = rep;
        }
        for (Map.Entry<Integer, Integer> entry : byteCount.entrySet()) {
            if (entry.getValue() == minRepeat) System.out.print(entry.getKey() + " ");
        }
    }
}
