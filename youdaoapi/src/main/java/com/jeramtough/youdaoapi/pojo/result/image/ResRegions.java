/**
 * Copyright 2019 bejson.com
 */
package com.jeramtough.youdaoapi.pojo.result.image;

/**
 * Auto-generated: 2019-01-24 21:34:23
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class ResRegions {

    private String boundingBox;
    private int linesCount;
    private int lineheight;
    private String context;
    private int linespace;
    private String tranContent;
    private String dir;
    private String lang;

    public void setBoundingBox(String boundingBox) {
        this.boundingBox = boundingBox;
    }

    public String getBoundingBox() {
        return boundingBox;
    }

    public void setLinesCount(int linesCount) {
        this.linesCount = linesCount;
    }

    public int getLinesCount() {
        return linesCount;
    }

    public void setLineheight(int lineheight) {
        this.lineheight = lineheight;
    }

    public int getLineheight() {
        return lineheight;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getContext() {
        return context;
    }

    public void setLinespace(int linespace) {
        this.linespace = linespace;
    }

    public int getLinespace() {
        return linespace;
    }

    public void setTranContent(String tranContent) {
        this.tranContent = tranContent;
    }

    public String getTranContent() {
        return tranContent;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getDir() {
        return dir;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }

    @Override
    public String toString() {
        return "ResRegions{" +
                "boundingBox='" + boundingBox + '\'' +
                ", linesCount=" + linesCount +
                ", lineheight=" + lineheight +
                ", context='" + context + '\'' +
                ", linespace=" + linespace +
                ", tranContent='" + tranContent + '\'' +
                ", dir='" + dir + '\'' +
                ", lang='" + lang + '\'' +
                '}';
    }
}