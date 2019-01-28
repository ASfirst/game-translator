import com.jeramtough.jtlog.facade.L;
import com.jeramtough.jtutil.core.KeyUtil;
import com.jeramtough.youdaoapi.DefaultYoudaoTranslator;
import com.jeramtough.youdaoapi.YoudaoTranslator;
import com.jeramtough.youdaoapi.exception.TranslateException;
import com.jeramtough.youdaoapi.pojo.result.image.ImageTranslationResult;
import com.jeramtough.youdaoapi.pojo.result.text.TextTranslationResult;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created on 2019-01-24 00:14
 * by @author JeramTough
 */
public class Test {

    @org.junit.Test
    public void translatingByImageFile() {
        File imageFile = new File(
                "E:\\Codes\\IdeaCodes\\game-translator\\app\\src\\test\\resources\\word.png");
        try {
            FileInputStream fileInputStream = new FileInputStream(imageFile);
            String imageBase64Str = KeyUtil.toBase64Str(IOUtils.toByteArray(fileInputStream));
            L.debug(imageBase64Str);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void tempPath() {
        String folder = System.getProperty("java.io.tmpdir");
        L.debug(folder);
    }

    @org.junit.Test
    public void testTranslateImageByYoudao() {
        File imageFile = new File(
                "E:\\Codes\\IdeaCodes\\game-translator\\app\\src\\test\\resources\\word.png");

        YoudaoTranslator youdaoTranslator = new DefaultYoudaoTranslator();
        ImageTranslationResult imageTranslationResult = null;
        try {
            imageTranslationResult = youdaoTranslator.translateImage(
                    imageFile);
        }
        catch (TranslateException e) {
            e.printStackTrace();
        }
        L.debug(imageTranslationResult);
    }

    @org.junit.Test
    public void testTranslateTextByYoudao() {
        String text = "my name is JeramTough";
        YoudaoTranslator youdaoTranslator = new DefaultYoudaoTranslator();
        try {
            TextTranslationResult textTranslationResult = youdaoTranslator.translateText(text);
            L.debug(textTranslationResult);
        }
        catch (TranslateException e) {
            e.printStackTrace();
        }
    }


}
