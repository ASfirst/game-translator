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

import javax.swing.*;

/**
 * Created on 2019-01-23 23:41
 * by @author JeramTough
 */
public class UserTest extends Application {

    public static final int GLOBAL_HOT_KEY_1 = 32432432;
    public static final int GLOBAL_HOT_KEY_2 = 32432433;
    public static final int GLOBAL_HOT_KEY_3 = 32432434;

    @Override
    public void start(Stage primaryStage) {
        Button registerButton = new Button();
        registerButton.setText("register hotkey");
        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                registerHotkey();
            }
        });

        Button cancelButton = new Button();
        cancelButton.setText("cancel hotkey");
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cancelHotkey();
            }
        });

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(registerButton, 0, 0);
        grid.add(cancelButton, 0, 1);

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World!");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


    private void registerHotkey() {
        //注册快捷键D
        JIntellitype.getInstance().registerHotKey(GLOBAL_HOT_KEY_1, 0, (int) 'D');
        //注册快捷键Shift+D
        JIntellitype.getInstance().registerHotKey(GLOBAL_HOT_KEY_2, JIntellitype.MOD_SHIFT,
                (int) 'D');
        //注册快捷键Shift+Ctrl+D
        JIntellitype.getInstance().registerHotKey(GLOBAL_HOT_KEY_3,
                JIntellitype.MOD_SHIFT + JIntellitype.MOD_CONTROL, (int) 'D');


        // 添加热键监听器
        // 第二步：添加热键监听器
        JIntellitype.getInstance().addHotKeyListener(new HotkeyListener() {
            public void onHotKey(int markCode) {
                switch (markCode) {
                    case GLOBAL_HOT_KEY_1:
                        JOptionPane.showMessageDialog(null, "注册快捷键(D):跳出弹框！", "提示消息",
                                JOptionPane.WARNING_MESSAGE);
                        break;
                    case GLOBAL_HOT_KEY_2:
                        JOptionPane.showMessageDialog(null, "注册快捷键(Shift+D):跳出弹框！", "提示消息",
                                JOptionPane.WARNING_MESSAGE);
                        break;
                    case GLOBAL_HOT_KEY_3:
                        JOptionPane.showMessageDialog(null, "注册快捷键(Shift+Ctrl+D):跳出弹框！",
                                "提示消息",
                                JOptionPane.WARNING_MESSAGE);
                        break;
                }
            }
        });
    }

    private void cancelHotkey() {
        JIntellitype.getInstance().unregisterHotKey(GLOBAL_HOT_KEY_1);
        JIntellitype.getInstance().unregisterHotKey(GLOBAL_HOT_KEY_2);
        JIntellitype.getInstance().unregisterHotKey(GLOBAL_HOT_KEY_3);
    }


}
