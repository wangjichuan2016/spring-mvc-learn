package com.wangjichuan.concurrent;

import com.wangjichuan.springmvc.utils.CommonUtils;
import com.wangjichuan.springmvc.utils.DateFormatUtils;

import java.util.concurrent.Callable;

/**
 * Created by wangjichuan on 17/4/11.
 */
public class MyTask<T> implements Callable<T> {
    private String name;
    private T delayTime;

    public MyTask(String name,T delayTime){
        this.name = name;
        this.delayTime = delayTime;
    }
    public T call() throws Exception {
//        CommonUtils.print("my_task name ----"+name+"-----delayTime="+delayTime+"----time="+ DateFormatUtils.currentTime());
        try {
            Thread.currentThread().sleep(Long.parseLong(delayTime+""));
        }catch (Exception e){
            CommonUtils.print("出异常了,delayTime="+delayTime);
        }
        return delayTime;
    }
}
