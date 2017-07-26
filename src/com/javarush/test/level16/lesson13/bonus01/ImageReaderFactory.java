package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by set on 26.07.17.
 */
public class ImageReaderFactory
{
    public static ImageReader getReader (ImageTypes l){
        if (l == ImageTypes.JPG) return new JpgReader();
        else if (l == ImageTypes.PNG) return new PngReader();
        else if (l == ImageTypes.BMP) return new  BmpReader();
        if (!(l instanceof ImageTypes)) throw new IllegalArgumentException();
        return null;
    }
}
