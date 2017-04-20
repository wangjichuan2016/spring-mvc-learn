package com.wangjichuan.springmvc.dao.impl;

import com.wangjichuan.springmvc.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

/**
 * Created by wangjichuan on 17/4/18.
 */
public abstract class BaseDaoImpl<T,K> implements BaseDao<T,K> {
    @Autowired
    private MongoTemplate mongoTemplate;
    public T findById(K k) {
        return mongoTemplate.findById(k,getEntityClass());
    }
    public boolean save(T t) {
        mongoTemplate.save(t);
        return true;
    }
    public List<T> list() {
        return mongoTemplate.findAll(getEntityClass());
    }
    public abstract Class<T> getEntityClass();
}
