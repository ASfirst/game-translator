package com.jeramtough.youdaoapi.util;

import com.jeramtough.jtutil.core.KeyUtil;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created on 2019-01-28 19:47
 * by @author JeramTough
 */
public class ImageUtil {

    public static String imageToBase64Str(File imageFile) {
        byte[] imageBytes = null;
        try {
            imageBytes = IOUtils.toByteArray(new FileInputStream(imageFile));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        String imageBase64Str = KeyUtil.toBase64Str(imageBytes);
        return imageBase64Str;
    }

    public static File compressImage(File imageFile) {
        /** 压缩图片 */
        long maxSize = 1 * 200 * 200;
        float quality = 0.7f;

        String tmpFilePath =
                imageFile.getParentFile().getAbsolutePath() + File.separator + "temp.png";
        String filePath = imageFile.getAbsolutePath();

        if (imageFile.length() > maxSize) {
            try {
                /** 设置图片大小和质量 */
                Thumbnails.of(filePath).scale(1f).outputQuality(quality).toFile(
                        new File(tmpFilePath));
                File tmpFile = new File(tmpFilePath);
                filePath = tmpFilePath;
                /** 连续压缩 */
                while (tmpFile.length() > maxSize) {
                    quality -= 0.2;
                    Thumbnails.of(filePath).scale(1f).outputQuality(quality).toFile(tmpFile);
                    tmpFile = new File(tmpFilePath);
                }
                imageFile = tmpFile;
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }
        return imageFile;
    }
}
