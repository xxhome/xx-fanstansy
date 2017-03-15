package com.fantasy.xxbase.vo;

import java.io.Serializable;

/**
 * Created by admin on 17/02/17.
 */
public class SimpleDataVO implements Serializable{

    private String id;

    private String name;

    public SimpleDataVO(String id, String name){
        this.id = id;
        this.name = name;
    }

    public SimpleDataVO(Long id, String name){
        this.id = String.valueOf(id);
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
