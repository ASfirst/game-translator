package com.jeramtough.youdaoapi.http;

import com.alibaba.fastjson.JSON;
import com.jeramtough.jtlog.facade.L;
import com.jeramtough.youdaoapi.bean.YoudaoRequestImageTranslationParameters;
import com.jeramtough.youdaoapi.bean.YoudaoRequestTextTranslationParameters;
import com.jeramtough.youdaoapi.pojo.result.image.ImageTranslationResult;
import okhttp3.*;

import java.io.IOException;

/**
 * Created on 2019-01-24 20:58
 * by @author JeramTough
 */
public class MyHttpClient {
    private volatile static MyHttpClient myHttpClient;
    private OkHttpClient okHttpClient;

    private MyHttpClient() {
        okHttpClient = new OkHttpClient();
    }

    public static MyHttpClient getInstance() {
        if (myHttpClient == null) {
            synchronized (MyHttpClient.class) {
                if (myHttpClient == null) {
                    myHttpClient = new MyHttpClient();
                }
            }
        }
        return myHttpClient;
    }

    public String invokingImageTranslationApi(
            YoudaoRequestImageTranslationParameters youdaoRequestImageTranslationParameters) {
        String url = "http://openapi.youdao.com/ocrtransapi";

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("type", youdaoRequestImageTranslationParameters.getType())
                .addFormDataPart("from", youdaoRequestImageTranslationParameters.getFrom())
                .addFormDataPart("to", youdaoRequestImageTranslationParameters.getTo())
                .addFormDataPart("appKey", youdaoRequestImageTranslationParameters.getAppKey())
                .addFormDataPart("docType", youdaoRequestImageTranslationParameters.getType())
                .addFormDataPart("salt", youdaoRequestImageTranslationParameters.getSalt())
                .addFormDataPart("q", youdaoRequestImageTranslationParameters.getQ())
                .addFormDataPart("sign", youdaoRequestImageTranslationParameters.getSign())
                .build();
        return processResultStr(url, requestBody);
    }

    public String invokingTextTranslationApi(
            YoudaoRequestTextTranslationParameters youdaoRequestTextTranslationParameters) {
        String url = "http://openapi.youdao.com/api";

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("from", youdaoRequestTextTranslationParameters.getFrom())
                .addFormDataPart("to", youdaoRequestTextTranslationParameters.getTo())
                .addFormDataPart("appKey", youdaoRequestTextTranslationParameters.getAppKey())
                .addFormDataPart("salt", youdaoRequestTextTranslationParameters.getSalt())
                .addFormDataPart("q", youdaoRequestTextTranslationParameters.getQ())
                .addFormDataPart("sign", youdaoRequestTextTranslationParameters.getSign())
                .build();

        return processResultStr(url, requestBody);
    }

    //*************************************

    private String processResultStr(String url, RequestBody requestBody) {
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            String resultStr = response.body().string();
            return resultStr;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

