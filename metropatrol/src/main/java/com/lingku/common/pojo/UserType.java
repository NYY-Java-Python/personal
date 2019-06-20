package com.lingku.common.pojo;

import java.util.Objects;

/**
 * @author NYY
 * @2019年5月28日 
 * @description 用户角色/类型
 */
public enum UserType {
    /**
     * 系统超级用户角色
     */
    SUPER_MANAGER("系统超级用户角色",1),

    /**
     * 工班班长
     */
    DEVELOPER("工班班长",2),

    /**
     * 领导
     */
    MANAGER("领导",3),

    /**
     * 系统管理员
     */
    SHOP_MASTER("系统管理员",4),

    /**
     * 巡道人员
     */
    FIXER("巡道人员",5);



    private String typeName;
    private Integer type;

    UserType(String typeName, Integer type) {
        this.type = type;
        this.typeName = typeName;
    }

    public static UserType getUserTypeById(Integer type){
        for(UserType userType : values()) {
            if (Objects.equals(userType.getType(), type)){
                return userType;
            }
        }

        return null;
    }

    public static UserType getUserTypeByTypeName(String typeName){
        for(UserType userType : values()) {
            if (Objects.equals(userType.getTypeName(), typeName)){
                return userType;
            }
        }
        return null;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

//    public boolean isSysUser(){
//        return this.type == 1 || this.type == 2 || this.type == 3;
//    }
}
