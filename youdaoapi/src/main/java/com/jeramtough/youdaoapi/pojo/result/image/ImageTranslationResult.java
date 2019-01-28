/**
 * Copyright 2019 bejson.com
 */
package com.jeramtough.youdaoapi.pojo.result.image;

import java.util.List;

/**
 * Auto-generated: 2019-01-24 21:34:23
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class ImageTranslationResult {

    private String orientation;
    private String lanFrom;
    private String textAngle;
    private String errorCode;
    private String lanTo;
    private List<ResRegions> resRegions;

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setLanFrom(String lanFrom) {
        this.lanFrom = lanFrom;
    }

    public String getLanFrom() {
        return lanFrom;
    }

    public void setTextAngle(String textAngle) {
        this.textAngle = textAngle;
    }

    public String getTextAngle() {
        return textAngle;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setLanTo(String lanTo) {
        this.lanTo = lanTo;
    }

    public String getLanTo() {
        return lanTo;
    }

    public void setResRegions(List<ResRegions> resRegions) {
        this.resRegions = resRegions;
    }

    public List<ResRegions> getResRegions() {
        return resRegions;
    }


    @Override
    public String toString() {
        String text = "ImageTranslationResult{" +
                "orientation='" + orientation + '\'' +
                ", lanFrom='" + lanFrom + '\'' +
                ", textAngle='" + textAngle + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", lanTo='" + lanTo + '\'' +
                ", resRegions=";
        for (ResRegions resRegion : resRegions) {
            text = text + resRegion.toString() + "\n";
        }
        text = text + "}";
        return text;

    }
}