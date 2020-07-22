package cn.hxzy.entity;


import java.io.Serializable;
import java.util.List;


public class RoleExt implements Serializable {
    private List<Resource> resources;

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}