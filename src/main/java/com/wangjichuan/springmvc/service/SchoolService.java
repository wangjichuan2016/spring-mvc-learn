package com.wangjichuan.springmvc.service;

import com.wangjichuan.springmvc.po.School;

import java.util.List;

/**
 * Created by wangjichuan on 17/4/18.
 */
public interface SchoolService {
    public School findById(Long id);
    public boolean save(School school);
    public List<School> list();
}
