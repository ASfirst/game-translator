package com.jeramtough.youdaoapi;

import com.jeramtough.youdaoapi.exception.TranslateException;
import com.jeramtough.youdaoapi.pojo.result.image.ImageTranslationResult;
import com.jeramtough.youdaoapi.pojo.result.text.TextTranslationResult;

import java.io.File;

/**
 * Created on 2019-01-24 20:21
 * by @author JeramTough
 */
public interface YoudaoTranslator {

    ImageTranslationResult translateImage(File imageFile) throws TranslateException;

    TextTranslationResult translateText(String text) throws TranslateException;
}
