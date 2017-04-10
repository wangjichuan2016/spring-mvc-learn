package simple.test;

import com.wangjichuan.springmvc.utils.CommonUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wangjichuan on 17/4/8.
 */
public class IteratorCon {
    @Test
    public void iteratorCon() throws Exception{
        List<String> data = initData();
        Thread thread1 = new IteraThread("thread1-----",data,500);
        thread1.start();
        thread1.join();
//        Thread thread2 = new IteraThread("thread2-----",data,400);
//        thread2.start();

    }

    @Test
    public void test() throws Exception{
        List<String> data = initData();
        for(String d : data){
            if(d.length()%2== 0){
                data.remove(d);
            }
        }

    }
    public List initData(){
        List<String> data = new ArrayList<String>();
        data.add("wangjichuan");
        data.add("jiangjian");
        data.add("jiangwei");
        data.add("pangchuanxiao");
        data.add("haha");
        data.add("nihao");
        return data;
    }
    class IteraThread extends Thread{
        private Collection<String> collection;
        private long sleepTime;
        private IteraThread(String threadName,Collection<String> collection,long sleepTime){
            super(threadName);
            this.collection = collection;
            this.sleepTime = sleepTime;
        }

        @Override
        public void run() {
           Iterator<String> iterator = collection.iterator();
            while (iterator.hasNext()){
                CommonUtils.print(getName()+"   "+iterator.next());
                iterator.remove();
                try {
                    sleep(sleepTime);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
