package com.jeramtough.gametranslator.component.ocr;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

/**
 * Created on 2019-01-28 21:13
 * by @author JeramTough
 */
public class MyTesseractor {

    private static final String TESS_DATA_DIRECTORY_PATH = "E:\\Environment\\Tesseract-OCR" +
            "\\tessdata";

    private static final String SOURCE_LANGUAGE = "eng";

    private volatile static MyTesseractor myTesseractor;

    private ITesseract tesseract;


    public MyTesseractor() {
        // JNA Interface Mapping
        tesseract = new Tesseract();
        tesseract.setDatapath(TESS_DATA_DIRECTORY_PATH);
        tesseract.setLanguage(SOURCE_LANGUAGE);
    }

    public static MyTesseractor getInstance() {
        if (myTesseractor == null) {
            synchronized (MyTesseractor.class) {
                if (myTesseractor == null) {
                    myTesseractor = new MyTesseractor();
                }
            }
        }
        return myTesseractor;
    }

    public String doOCR(File imageFile) throws TesseractException {
        String result = tesseract.doOCR(imageFile);
        return result;
    }
}
