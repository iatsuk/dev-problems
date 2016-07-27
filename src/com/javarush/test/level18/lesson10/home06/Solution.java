package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream fis = new FileInputStream(args[0]);
        Map<Character, Integer> sp = new TreeMap<>();
        while (fis.available() > 0) {
            char data = (char) fis.read();
            if (sp.containsKey(data)) {
                sp.put(data, sp.remove(data) + 1);
            } else {
                sp.put(data, 1);
            }
        }
        fis.close();

        for (Map.Entry<Character, Integer> entry : sp.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
