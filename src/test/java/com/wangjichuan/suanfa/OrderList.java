package com.wangjichuan.suanfa;

import com.wangjichuan.springmvc.utils.CommonUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjichuan on 17/4/8.
 */
public class OrderList {
    @Test
    public void test(){
        List<Integer> data = new ArrayList<Integer>();
        initData(data);
        printList(data);
        moveLeft(data,2);
        CommonUtils.print("");
        printList(data);
    }
    //对列表向左移动p个位置
    public void moveLeft(List<Integer> data,Integer p){
        reverse(data,0,p-1);
        reverse(data,p,data.size()-1);
        reverse(data,0,data.size() -1);

    }
    public void reverse(List<Integer> data,Integer from,Integer to){
        int temp = 0;
        for(int i= 0;i<(to - from)/2;i++){
            temp = data.get(from+i);
            data.set(from+i, data.get(to - i));
            data.set(to - i,temp);
        }

    }
    public void initData(List<Integer> data){
        data.add(1);
        data.add(8);
        data.add(9);
        data.add(1);
        data.add(1);
        data.add(2);
        data.add(4);
        data.add(0);
        data.add(4);
        data.add(5);
        data.add(0);
    }
    public void printList(List<Integer> data){
        for(Integer d : data){
            System.out.print(d);
        }
    }
}
