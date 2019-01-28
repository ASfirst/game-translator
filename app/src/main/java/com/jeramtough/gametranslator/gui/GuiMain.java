package com.jeramtough.gametranslator.gui;

import com.jeramtough.gametranslator.business.MainBusiness;
import com.jeramtough.gametranslator.business.MainBusinessImpl;
import com.jeramtough.jtcomponent.task.bean.TaskResult;
import com.jeramtough.jtcomponent.task.callback.SimpleTaskCallback;
import com.jeramtough.jtlog.facade.L;
import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created on 2019-01-24 21:45
 * by @author JeramTough
 */
public class GuiMain extends Application implements HotkeyListener {

    private static final int GLOBAL_HOT_KEY_1 = 32432432;

    private MainBusiness mainBusiness;
    private TranslateTaskCallback translateTaskCallback;

    private Button registerButton;
    private Button cancelButton;
    private Button translateButton;

    public GuiMain() {
        mainBusiness = new MainBusinessImpl();
        translateTaskCallback = new TranslateTaskCallback();
    }

    @Override
    public void start(Stage primaryStage) {
        registerButton = new Button();
        registerButton.setText("register hotkey");
        registerButton.setOnAction(event -> registerHotkey());

        cancelButton = new Button();
        cancelButton.setText("cancel hotkey");
        cancelButton.setOnAction(event -> cancelHotkey());

        translateButton = new Button();
        translateButton.setText("translating");
        translateButton.setOnAction(
                event -> mainBusiness.startTranslating(translateTaskCallback));

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(registerButton, 0, 0);
        grid.add(cancelButton, 0, 1);
        grid.add(translateButton, 0, 2);

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game Translator");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void onHotKey(int identifier) {
        if (identifier == GLOBAL_HOT_KEY_1) {
            mainBusiness.startTranslating(translateTaskCallback);
        }
    }

    public class TranslateTaskCallback extends SimpleTaskCallback {

        @Override
        public void onTaskStart() {
            translateButton.setOnAction(null);
        }

        @Override
        public void onTaskRunning(TaskResult taskResult, int percent) {
            L.debugs(percent, taskResult.getMessage());
        }

        @Override
        public void onTaskCompleted(TaskResult taskResult) {
            if (taskResult.isSuccessful()) {
                String sourceText = taskResult.getStringPayload("sourceText");
                String translationText = taskResult.getStringPayload(
                        "translationText");
                L.debug(sourceText + "\n" + translationText);
            }

            translateButton.setOnAction(event -> {
                mainBusiness.startTranslating(translateTaskCallback);
            });
        }
    }

    @Override
    protected void finalize() throws Throwable {
        cancelHotkey();
        L.arrive();
        super.finalize();
    }


    //******************************

    private void registerHotkey() {
        //注册快捷键Alt+X
        JIntellitype.getInstance().registerHotKey(GLOBAL_HOT_KEY_1, JIntellitype.MOD_ALT,
                (int) 'X');

        // 添加热键监听器
        // 第二步：添加热键监听器
        JIntellitype.getInstance().addHotKeyListener(this);
    }

    private void cancelHotkey() {
        JIntellitype.getInstance().unregisterHotKey(GLOBAL_HOT_KEY_1);
    }


}
