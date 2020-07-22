package cn.hxzy.entity;

import java.io.Serializable;

public class UserExt implements Serializable {
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
