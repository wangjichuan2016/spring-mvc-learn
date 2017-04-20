package com.wangjichuan.springmvc.dao;

import java.util.List;

/**
 * Created by wangjichuan on 17/4/18.
 */
public interface BaseDao<T,K> {
    public T findById(K k);
    public boolean save(T t);
    public List<T> list();
}
