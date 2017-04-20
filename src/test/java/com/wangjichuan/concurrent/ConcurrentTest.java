package com.wangjichuan.concurrent;

import com.wangjichuan.springmvc.utils.CommonUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by wangjichuan on 17/4/11.
 */
public class ConcurrentTest {
    @Test
    public void test() throws Exception{
        int taskSize = 90;
        int costTime = 300;
        blockFuture(taskSize,costTime);
        noneBlockFuture(taskSize,costTime);
    }
    public void blockFuture(int taskSize,int costTime) throws Exception{
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        List<Future> futures = new ArrayList<Future>();
        long start = System.currentTimeMillis();
        Random random = new Random();
        for(int i=0;i<taskSize;i++){
            MyTask<Integer> myTask = new MyTask<Integer>("task["+i+"]",costTime);
            Future<Integer> future = threadPool.submit(myTask);
            futures.add(future);
        }
        for(Future<Integer> future : futures){
            future.get();
        }
        threadPool.shutdown();
        long end = System.currentTimeMillis();
        CommonUtils.print("blockFuture cost time end-start="+(end-start));
    }

    public void noneBlockFuture(int taskSize,int costTime) throws Exception{
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(threadPool);
        long start = System.currentTimeMillis();
        Random random = new Random();
        for(int i=0;i<taskSize;i++){
            MyTask<Integer> myTask = new MyTask<Integer>("task["+i+"]",costTime);
            completionService.submit(myTask);
        }
        for(int i=0;i<taskSize;i++){
            completionService.take().get();
        }
        threadPool.shutdown();
        long end = System.currentTimeMillis();
        CommonUtils.print("noneBlockFuture cost time end-start="+(end-start));
    }
}
