package com.fantasy.xxbase.entity;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class XXTreeEntity<T extends XXTreeEntity> extends XXSimpleEntity{


    /**
     * 层级
     */
    private int level;


    /**
     * 是否叶子节点
     */
    private boolean leaf;


    /**
     * 只节点
     */
    @Transient
    private List<T> children = new ArrayList<>();



    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }
}
