package com.jeramtough.youdaoapi;

import com.alibaba.fastjson.JSON;
import com.jeramtough.youdaoapi.bean.YoudaoRequestImageTranslationParameters;
import com.jeramtough.youdaoapi.bean.YoudaoRequestTextTranslationParameters;
import com.jeramtough.youdaoapi.exception.TranslateException;
import com.jeramtough.youdaoapi.factory.YoudaoRequestParametersFactory;
import com.jeramtough.youdaoapi.http.MyHttpClient;
import com.jeramtough.youdaoapi.pojo.result.image.ImageTranslationResult;
import com.jeramtough.youdaoapi.pojo.result.text.TextTranslationResult;
import com.jeramtough.youdaoapi.util.ImageUtil;

import java.io.File;

/**
 * Created on 2019-01-24 20:23
 * by @author JeramTough
 */
public class DefaultYoudaoTranslator implements YoudaoTranslator {

    private static volatile DefaultYoudaoTranslator youdaoTranslator;

    private DefaultYoudaoTranslator() {
    }

    public static DefaultYoudaoTranslator getInstance() {
        if (youdaoTranslator == null) {
            synchronized (DefaultYoudaoTranslator.class) {
                if (youdaoTranslator == null) {
                    youdaoTranslator = new DefaultYoudaoTranslator();
                }
            }
        }
        return youdaoTranslator;
    }

    @Override
    public ImageTranslationResult translateImage(File imageFile) throws TranslateException {
        MyHttpClient myHttpClient = MyHttpClient.getInstance();

        imageFile = ImageUtil.compressImage(imageFile);

        String imageBase64Str = ImageUtil.imageToBase64Str(imageFile);

        YoudaoRequestImageTranslationParameters youdaoRequestImageTranslationParameters =
                YoudaoRequestParametersFactory.getYoudaoRequestImageTranslationParameters(
                        imageBase64Str);

        String resultJsonStr =
                myHttpClient.invokingImageTranslationApi(
                        youdaoRequestImageTranslationParameters);

        ImageTranslationResult imageTranslationResult;
        if (resultJsonStr == null) {
            throw new TranslateException();
        }
        try {
            imageTranslationResult = JSON.parseObject(imageBase64Str,
                    ImageTranslationResult.class);
            return imageTranslationResult;
        }
        catch (Exception e) {
            throw new TranslateException();
        }


    }

    @Override
    public TextTranslationResult translateText(String text) throws TranslateException {
        MyHttpClient myHttpClient = MyHttpClient.getInstance();

        YoudaoRequestTextTranslationParameters youdaoRequestTextTranslationParameters =
                YoudaoRequestParametersFactory.getYoudaoRequestTextTranslationParameters(text);

        String resultJsonStr =
                myHttpClient.invokingTextTranslationApi(
                        youdaoRequestTextTranslationParameters);

        TextTranslationResult textTranslationResult;
        if (resultJsonStr == null) {
            throw new TranslateException();
        }
        try {
            textTranslationResult = JSON.parseObject(resultJsonStr,
                    TextTranslationResult.class);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new TranslateException();
        }

        return textTranslationResult;
    }

}
