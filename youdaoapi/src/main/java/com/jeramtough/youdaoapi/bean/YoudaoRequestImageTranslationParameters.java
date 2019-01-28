package com.jeramtough.youdaoapi.bean;

/**
 * Created on 2019-01-24 01:29
 * by @author JeramTough
 */
public class YoudaoRequestImageTranslationParameters extends YoudaoRequestParameters {

    private String docType = "json";
    private String type = "1";


    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
