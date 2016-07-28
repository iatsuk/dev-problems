package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter {
    private FileOutputStream component;

    AdapterFileOutputStream(FileOutputStream component) {
        this.component = component;
    }

    @Override
    public void flush() throws IOException
    {
        component.flush();
    }

    @Override
    public void writeString(String s) throws IOException
    {
        component.write(s.getBytes());
    }

    @Override
    public void close() throws IOException
    {
        component.close();
    }
}

