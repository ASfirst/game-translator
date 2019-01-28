import com.jeramtough.gametranslator.component.ocr.MyTesseractor;
import com.jeramtough.gametranslator.util.ClipboardUtil;
import com.jeramtough.jtlog.facade.L;
import net.sourceforge.tess4j.TesseractException;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created on 2019-01-24 00:14
 * by @author JeramTough
 */
public class TranslationTest {

    @org.junit.Test
    public void createImageFileFromClipboard() {
        Image image = ClipboardUtil.getImageFromClipboard();
        if (image != null) {
            int width = image.getWidth(null);
            int height = image.getHeight(null);
            //得到图片缓冲区
            //INT精确度达到一定,RGB三原色，高度70,宽度150
            BufferedImage bufferedImage = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            bufferedImage.getGraphics().drawImage(image, 0, 0, width, height, null);
            bufferedImage.getGraphics().dispose();

            try {
                ImageIO.write(bufferedImage, "png", new File("E:\\Codes\\IdeaCodes\\game" +
                        "-translator\\app\\src\\test\\resources\\a.png"));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @org.junit.Test
    public void translateImageToText() {
        MyTesseractor myTesseractor = MyTesseractor.getInstance();
        File imageFile = new File(
                "E:\\Codes\\IdeaCodes\\game-translator\\app\\src\\test\\resources\\test1.png");
        try {
            String text = myTesseractor.doOCR(imageFile);
            L.debug(text);
        }
        catch (TesseractException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void tempImageTest(){
        File imageFile = null;
        try {
            imageFile = File.createTempFile("game-translated-screenshot",
                    ".png");
            L.debug(imageFile.getAbsolutePath());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        imageFile.deleteOnExit();
    }

}
