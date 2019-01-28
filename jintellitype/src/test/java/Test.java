import com.jeramtough.jtlog.facade.L;
import com.melloware.jintellitype.JIntellitype;
import javafx.scene.input.KeyCode;

/**
 * Created on 2019-01-23 22:54
 * by @author JeramTough
 */
public class Test {


    @org.junit.Test
    public void pathTest() {
        L.debug(getClass().getName());
        L.debug(getClass().getResource("JIntellitype64.dll"));
        String path = getClass().getResource("JIntellitype64.dll").getFile();
        L.debug(path);
        System.load(path);
    }

    @org.junit.Test
    public void test2() {
        L.debugs(KeyCode.X.ordinal(), (int) 'X');
    }


}
