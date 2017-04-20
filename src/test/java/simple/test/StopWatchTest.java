package simple.test;

import com.wangjichuan.springmvc.utils.CommonUtils;
import org.apache.commons.lang.time.StopWatch;
import org.junit.Test;

/**
 * Created by wangjichuan on 17/4/19.
 */
public class StopWatchTest {
    @Test
    public void test() throws Exception{
        StopWatch stopwatch =  new StopWatch();
        stopwatch.start();
        Thread.currentThread().sleep(1000);
        CommonUtils.print(stopwatch.getTime());

        Thread.currentThread().sleep(1000);
        stopwatch.stop();
        CommonUtils.print(stopwatch.getTime());
    }
}
