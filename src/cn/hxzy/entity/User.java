package cn.hxzy.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class User extends UserExt implements Serializable {
    private Integer id;
    private String name;
    private String loginName;
    private String loginPassword;
    private Integer roleId;
    private Date createTime;
    private Date updateTime;

    public User() {
    }


    public User(Integer id, String name, String loginName, String loginPassword, Integer roleId, String roleName, Date create_time, Date updateTime, Timestamp createTime) {
        this.id = id;
        this.name = name;
        this.loginName = loginName;
        this.loginPassword = loginPassword;
        Role role = new Role();
        role.setName(roleName);
        role.setId(roleId);
        this.setRole(role);
        this.roleId = roleId;
        this.createTime = create_time;
        this.updateTime = updateTime;
        this.createTime = createTime;
    }

    public User(String name, String loginName, String loginPassword, Integer roleId, String roleName) {
        this.name = name;
        this.loginName = loginName;
        this.loginPassword = loginPassword;
        Role role = new Role();
        role.setId(roleId);
        this.roleId = roleId;
        role.setName(roleName);
        this.setRole(role);
    }

    public User(Integer id, String name, String loginPassword, Integer roleId, String roleName) {
        this.id = id;
        this.name = name;
        this.loginPassword = loginPassword;
        Role role = new Role();
        role.setName(roleName);
        role.setId(roleId);
        this.setRole(role);
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
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
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
