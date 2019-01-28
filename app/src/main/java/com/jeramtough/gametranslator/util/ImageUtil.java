package com.jeramtough.gametranslator.util;

import com.sun.istack.internal.NotNull;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created on 2019-01-28 21:33
 * by @author JeramTough
 */
public class ImageUtil {

    public static void saveImageToFile(@NotNull Image image, File toImageFile) throws
            IOException {

        int width = image.getWidth(null);
        int height = image.getHeight(null);
        //得到图片缓冲区
        //INT精确度达到一定,RGB三原色，高度70,宽度150
        BufferedImage bufferedImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        bufferedImage.getGraphics().drawImage(image, 0, 0, width, height, null);
        bufferedImage.getGraphics().dispose();

        ImageIO.write(bufferedImage, "png", toImageFile);
    }

}
