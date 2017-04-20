package com.wangjichuan.springmvc.dao.impl;

import com.wangjichuan.springmvc.dao.SchoolDao;
import com.wangjichuan.springmvc.po.School;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by wangjichuan on 17/4/18.
 */
@Repository("schoolDao")
public class SchoolDaoImpl extends BaseDaoImpl<School,Long> implements SchoolDao {

    @Override
    public Class<School> getEntityClass() {
        return School.class;
    }
}
