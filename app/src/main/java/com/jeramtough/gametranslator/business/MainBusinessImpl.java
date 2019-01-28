package com.jeramtough.gametranslator.business;

import com.jeramtough.gametranslator.component.ocr.MyTesseractor;
import com.jeramtough.gametranslator.util.ClipboardUtil;
import com.jeramtough.gametranslator.util.ImageUtil;
import com.jeramtough.jtcomponent.task.bean.no.TaskResult;
import com.jeramtough.jtcomponent.task.callback.RunningTaskCallback;
import com.jeramtough.jtcomponent.task.callback.TaskCallback;
import com.jeramtough.jtcomponent.task.response.AsyncTaskResponse;
import com.jeramtough.jtcomponent.task.response.DefaultTaskResponse;
import com.jeramtough.jtcomponent.task.response.FutureAsyncTaskResponse;
import com.jeramtough.jtcomponent.task.response.TaskResponse;
import com.jeramtough.jtcomponent.task.runnable.SimpleTaskable;
import com.jeramtough.jtcomponent.task.runnable.TaskableWithCallback;
import com.jeramtough.jtlog.facade.L;
import com.jeramtough.youdaoapi.DefaultYoudaoTranslator;
import com.jeramtough.youdaoapi.YoudaoTranslator;
import com.jeramtough.youdaoapi.exception.TranslateException;
import com.jeramtough.youdaoapi.pojo.result.text.TextTranslationResult;
import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;
import net.sourceforge.tess4j.TesseractException;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created on 2019-01-24 21:44
 * by @author JeramTough
 */
public class MainBusinessImpl implements MainBusiness {

    @Override
    public AsyncTaskResponse startTranslating(TaskCallback taskCallback) {
        return new FutureAsyncTaskResponse(new TaskableWithCallback(taskCallback) {
            @Override
            public boolean doTask(TaskResult taskResult, RunningTaskCallback taskCallback) {
                //get image from clipboard
                Image image = ClipboardUtil.getImageFromClipboard();
                if (image != null) {
                    taskResult.setMessage("Successfully get image from clipboard");
                    taskCallback.onTaskRunning(taskResult, 1);

                    try {
                        //saving image to local the file system
                        File imageFile = File.createTempFile("game-translated-screenshot",
                                ".png");
                        imageFile.deleteOnExit();
                        ImageUtil.saveImageToFile(image, imageFile);
                        taskResult.setMessage(
                                "Successfully saved image to[ " + imageFile.getAbsolutePath() +
                                        " ]");
                        taskCallback.onTaskRunning(taskResult, 2);


                        //do OCR
                        String text = MyTesseractor.getInstance().doOCR(imageFile);
                        taskResult.setMessage(
                                "Successfully recognize the text of image is\n" + text);
                        taskCallback.onTaskRunning(taskResult, 3);

                        //translating en to ch
                        YoudaoTranslator youdaoTranslator = DefaultYoudaoTranslator.getInstance();
                        TextTranslationResult textTranslationResult =
                                youdaoTranslator.translateText(text);
                        if (textTranslationResult.getTranslation().size() > 0) {
                            String translationText =
                                    textTranslationResult.getTranslation().get(0);
                            taskResult.setMessage(
                                    "Successfully translate the text of image is\n" + translationText);
                            taskResult.putPayload("sourceText", text);
                            taskResult.putPayload("translationText", translationText);
                            return true;
                        }
                        else {
                            throw new TranslateException();
                        }
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                        taskResult.setMessage(
                                "Failed to save image to local ,\n" + e.getMessage());
                        return false;
                    }
                    catch (TesseractException e) {
                        e.printStackTrace();
                        taskResult.setMessage(
                                "Failed to ocd image ,\n" + e.getMessage());
                        return false;
                    }
                    catch (TranslateException e) {
                        e.printStackTrace();
                        taskResult.setMessage(
                                "Failed to translate text ,\n" + e.getMessage());
                        return false;
                    }
                }
                else {
                    taskResult.setMessage("Can't get image from clipboard .");
                    taskCallback.onTaskRunning(taskResult, 0);
                    return false;
                }
            }
        }).start();
    }
}
