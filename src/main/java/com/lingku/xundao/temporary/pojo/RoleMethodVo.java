package com.lingku.xundao.temporary.pojo;

import java.util.Date;

/**
 * Created by tianxiaolong on 2019/3/11.
 */
public class RoleMethodVo {
    private Integer id;
    /**
     * 操作英文标志
     */
    private String name;
    /**
     * 操作中文名称
     */
    private String chineseName;

    private Date creatTime;

    private boolean contain = true;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public boolean isContain() {
        return contain;
    }

    public void setContain(boolean contain) {
        this.contain = contain;
    }
}