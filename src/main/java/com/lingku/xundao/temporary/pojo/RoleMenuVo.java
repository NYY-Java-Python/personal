package com.lingku.xundao.temporary.pojo;

import java.util.List;

/**
 * Created by tianxiaolong on 2019/3/11.
 */
public class RoleMenuVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 权限名称
     */
    private String name;

    private String chineseName;
    /**
     * 权限描述
     */
    private String desc;
    /**
     * 菜单层级
     */
    private Integer level;

    /**
     * 该层级顺序
     */
    private Integer order;
    /**
     * 最后一级菜单
     */
    private boolean lastLevel;
    /**
     * 末级菜单对应页面路径
     */
    private String urlPath;

    private Integer parentId;

    private String filePath;

    private boolean contain = true;

    List<RoleMenuVo> children;

    List<RoleMethodVo> allMethod;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public boolean isLastLevel() {
        return lastLevel;
    }

    public void setLastLevel(boolean lastLevel) {
        this.lastLevel = lastLevel;
    }

    public boolean isContain() {
        return contain;
    }

    public void setContain(boolean contain) {
        this.contain = contain;
    }

    public List<RoleMenuVo> getChildren() {
        return children;
    }

    public void setChildren(List<RoleMenuVo> children) {
        this.children = children;
    }

    public List<RoleMethodVo> getAllMethod() {
        return allMethod;
    }

    public void setAllMethod(List<RoleMethodVo> allMethod) {
        this.allMethod = allMethod;
    }
}