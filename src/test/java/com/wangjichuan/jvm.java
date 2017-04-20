package com.wangjichuan;

import com.wangjichuan.springmvc.utils.CommonUtils;
import org.junit.Test;

/**
 * Created by wangjichuan on 17/4/19.
 */
public class jvm {
    @Test
    public void testHook() throws Exception{
        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new Thread(new Runnable() {
            public void run() {
                CommonUtils.print("结束了");
            }
        }));
        long a = 1024*1024;
        for(int i=0;i<100;i++) {
            CommonUtils.print("free=" + runtime.freeMemory()/a + "-------total=" + runtime.totalMemory()/a + "-------max=" + runtime.maxMemory()/a);
            Thread.currentThread().sleep(1000);
        }

    }

}
