package cn.hxzy.entity;

import java.io.Serializable;
import java.util.Date;


public class Resource extends ResourceExt implements Serializable {
    private Integer id;
    private String name;
    private String url;
    private Integer pid;
    private Date createTime;
    private Date updateTime;
    private Integer orderNumber;

    public Resource() {
    }


    public Resource(Integer id, String name, String url, Integer pid, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.pid = pid;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Resource(String name, String url, int pid) {
        this.name = name;
        this.url = url;
        this.pid = pid;
    }

    public Resource(String name, String url, Integer pid,Integer orderNumber) {
        this.name = name;
        this.url = url;
        this.pid = pid;
        this.orderNumber = orderNumber;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", pid=" + pid +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
