package cn.hxzy.entity;


import java.io.Serializable;
import java.util.Date;

public class Role extends RoleExt implements Serializable {

    private Integer id;
    private String name;
    private String remark;
    private Date createTime;
    private Date updateTime;

    public Role() {
    }

    public Role(Integer id, String name, String remark, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.remark = remark;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Role(String name, String remark) {
        this.name = name;
        this.remark = remark;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
