package cn.hxzy.entity;

import java.io.Serializable;
import java.util.List;

public class ResourceExt implements Serializable {
    private List<Resource> son;

    public List<Resource> getSon() {
        return son;
    }

    public void setSon(List<Resource> son) {
        this.son = son;
    }
}
