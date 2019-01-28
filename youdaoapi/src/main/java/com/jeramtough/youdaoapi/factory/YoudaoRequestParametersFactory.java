package com.jeramtough.youdaoapi.factory;

import com.jeramtough.jtutil.core.KeyUtil;
import com.jeramtough.youdaoapi.bean.YoudaoRequestImageTranslationParameters;
import com.jeramtough.youdaoapi.bean.YoudaoRequestParameters;
import com.jeramtough.youdaoapi.bean.YoudaoRequestTextTranslationParameters;

import java.nio.charset.StandardCharsets;

/**
 * Created on 2019-01-24 20:29
 * by @author JeramTough
 */
public class YoudaoRequestParametersFactory {

    public static YoudaoRequestImageTranslationParameters getYoudaoRequestImageTranslationParameters(
            String imageBase64Str) {
        YoudaoRequestImageTranslationParameters youdaoRequestImageTranslationParameters = new YoudaoRequestImageTranslationParameters();
        youdaoRequestImageTranslationParameters.setQ(imageBase64Str);

        setYoudaoRequestParameters(youdaoRequestImageTranslationParameters);

        return youdaoRequestImageTranslationParameters;
    }

    public static YoudaoRequestTextTranslationParameters getYoudaoRequestTextTranslationParameters(
            String text) {
        YoudaoRequestTextTranslationParameters youdaoRequestTextTranslationParameters =
                new YoudaoRequestTextTranslationParameters();
        text = new String(text.getBytes(), StandardCharsets.UTF_8);
        youdaoRequestTextTranslationParameters.setQ(text);

        setYoudaoRequestParameters(youdaoRequestTextTranslationParameters);

        return youdaoRequestTextTranslationParameters;
    }


    //*************
    
    private static void setYoudaoRequestParameters(
            YoudaoRequestParameters youdaoRequestParameters) {
        youdaoRequestParameters.setSalt(
                String.valueOf(System.currentTimeMillis()));

        String sign = youdaoRequestParameters.getAppKey() + youdaoRequestParameters.getQ()
                + youdaoRequestParameters.getSalt()
                + youdaoRequestParameters.getAppSecret();
        byte[] bytes = KeyUtil.encryptByMD5(sign);
        sign = KeyUtil.to16Hex32LengthString(bytes, true);

        youdaoRequestParameters.setSign(sign);
    }


}
