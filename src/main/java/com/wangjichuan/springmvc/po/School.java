package com.wangjichuan.springmvc.po;

/**
 * Created by wangjichuan on 17/4/18.
 */

public class School {
    private Long id;
    private String createTime;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
