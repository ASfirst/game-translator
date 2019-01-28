/**
  * Copyright 2019 bejson.com 
  */
package com.jeramtough.youdaoapi.pojo.result.text;
import java.util.List;

/**
 * Auto-generated: 2019-01-28 20:2:19
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class TextTranslationResult {

    private String tSpeakUrl;
    private String query;
    private List<String> translation;
    private String errorCode;
    private Dict dict;
    private Webdict webdict;
    private String basic;
    private String l;
    private String speakUrl;
    public void setTSpeakUrl(String tSpeakUrl) {
         this.tSpeakUrl = tSpeakUrl;
     }
     public String getTSpeakUrl() {
         return tSpeakUrl;
     }

    public void setQuery(String query) {
         this.query = query;
     }
     public String getQuery() {
         return query;
     }

    public void setTranslation(List<String> translation) {
         this.translation = translation;
     }
     public List<String> getTranslation() {
         return translation;
     }

    public void setErrorCode(String errorCode) {
         this.errorCode = errorCode;
     }
     public String getErrorCode() {
         return errorCode;
     }

    public void setDict(Dict dict) {
         this.dict = dict;
     }
     public Dict getDict() {
         return dict;
     }

    public void setWebdict(Webdict webdict) {
         this.webdict = webdict;
     }
     public Webdict getWebdict() {
         return webdict;
     }

    public void setBasic(String basic) {
         this.basic = basic;
     }
     public String getBasic() {
         return basic;
     }

    public void setL(String l) {
         this.l = l;
     }
     public String getL() {
         return l;
     }

    public void setSpeakUrl(String speakUrl) {
         this.speakUrl = speakUrl;
     }
     public String getSpeakUrl() {
         return speakUrl;
     }


    @Override
    public String toString() {
        return "TextTranslationResult{" +
                "tSpeakUrl='" + tSpeakUrl + '\'' +
                ", query='" + query + '\'' +
                ", translation=" + translation +
                ", errorCode='" + errorCode + '\'' +
                ", dict=" + dict +
                ", webdict=" + webdict +
                ", basic='" + basic + '\'' +
                ", l='" + l + '\'' +
                ", speakUrl='" + speakUrl + '\'' +
                '}';
    }
}