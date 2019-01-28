import com.jeramtough.gametranslator.business.MainBusiness;
import com.jeramtough.gametranslator.business.MainBusinessImpl;
import com.jeramtough.jtcomponent.task.bean.TaskResult;
import com.jeramtough.jtcomponent.task.callback.TaskCallback;
import com.jeramtough.jtlog.facade.L;

/**
 * Created on 2019-01-28 21:28
 * by @author JeramTough
 */
public class Test {

    public static void main(String[] args) {
        mainBusiness();
    }

    public static void mainBusiness() {
        MainBusiness mainBusiness = new MainBusinessImpl();
        mainBusiness.startTranslating(new TaskCallback() {
            @Override
            public void onTaskStart() {
                L.arrive();
            }

            @Override
            public void onTaskRunning(TaskResult taskResult, int percent) {
                L.debugs(percent, taskResult.getMessage());
            }

            @Override
            public void onTaskCompleted(TaskResult taskResult) {
                L.debug(taskResult.getDetail());
            }
        });
    }

}
