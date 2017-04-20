package com.wangjichuan.springmvc.service.impl;

import com.wangjichuan.springmvc.service.HelloService;
import com.wangjichuan.springmvc.utils.CommonUtils;
import org.springframework.stereotype.Service;

/**
 * Created by wangjichuan on 17/4/18.
 */
@Service
public class HelloServiceImpl implements HelloService {
    public void hello() {
        CommonUtils.print("hello world");
    }
}
