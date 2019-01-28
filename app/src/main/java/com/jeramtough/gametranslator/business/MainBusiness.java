package com.jeramtough.gametranslator.business;

import com.jeramtough.jtcomponent.task.callback.TaskCallback;
import com.jeramtough.jtcomponent.task.response.AsyncTaskResponse;

/**
 * Created on 2019-01-24 21:38
 * by @author JeramTough
 */
public interface MainBusiness {

    /**
     * start translating by the image in clipboard
     */
    AsyncTaskResponse startTranslating(TaskCallback taskCallback);
}
