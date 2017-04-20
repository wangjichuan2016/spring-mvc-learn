package com.wangjichuan.springmvc.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangjichuan on 17/4/11.
 */
public class DateFormatUtils {
    private DateFormatUtils(){

    }
    private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String currentTime(){
        return simpleDateFormat.format(new Date());
    }
}
