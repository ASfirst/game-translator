package com.jeramtough.youdaoapi.bean;

/**
 * Created on 2019-01-28 19:04
 * by @author JeramTough
 */
public class YoudaoRequestTextTranslationParameters extends YoudaoRequestParameters {

    private String ext = "mp3";
    private String voice = "0";

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }
}
