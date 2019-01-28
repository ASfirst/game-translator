import com.jeramtough.youdaoapi.util.ImageUtil;
import org.junit.Test;

import java.io.File;

/**
 * Created on 2019-01-28 20:50
 * by @author JeramTough
 */
public class ImageTest {

    @Test
    public void test() {
        ImageUtil.compressImage(new File("E:\\Codes\\IdeaCodes\\game-translator\\youdaoapi" +
                "\\src\\test\\resources\\rrr.png"));
    }
}
