package com.jeramtough.youdaoapi.bean;

/**
 * Created on 2019-01-28 18:39
 * by @author JeramTough
 */
public class YoudaoRequestParameters {

    private String from = "en";
    private String to = "zh-CHS";
    private String appKey = "40fa6ce27bd0948a";
    private String appSecret = "xjgUxWeVUHf5i1hb92l87RmZSMjQAEd4";
    private String sign;
    private String salt;
    private String q;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }
}
