package com.wangjichuan.springmvc.service.impl;

import com.wangjichuan.springmvc.dao.SchoolDao;
import com.wangjichuan.springmvc.po.School;
import com.wangjichuan.springmvc.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangjichuan on 17/4/18.
 */
@Service("schoolService")
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolDao schoolDao;
    public School findById(Long id) {
        return schoolDao.findById(id);
    }
    public boolean save(School school) {
        return schoolDao.save(school);
    }
    public List<School> list() {
        return schoolDao.list();
    }
}
