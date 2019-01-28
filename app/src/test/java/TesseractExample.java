import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.io.IOException;

/**
 * Created on 2019-01-28 15:11
 * by @author JeramTough
 */
public class TesseractExample {

    public static void main(String[] args) {

        File imageFile = new File(
                "E:\\Codes\\IdeaCodes\\game-translator\\app\\src\\test\\resources\\word.png");
        ITesseract instance = new Tesseract();  // JNA Interface Mapping
        instance.setDatapath("E:\\Environment\\Tesseract-OCR\\tessdata");
        instance.setLanguage("eng");

        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        }
        catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}
