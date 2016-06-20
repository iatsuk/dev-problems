package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes imgType) {
        switch (imgType) {
            case JPG: return new JpgReader();
            case PNG: return new PngReader();
            case BMP: return new BmpReader();
            default: throw new IllegalArgumentException("Неизвестный тип картинки");
        }
    }
}
