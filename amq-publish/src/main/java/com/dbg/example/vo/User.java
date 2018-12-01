package com.dbg.example.vo;
/*************************
 *          /\_/\
 *       =( °w° )=
 *          )   (  
 *         (__ __)
 *
 *     神兽保佑，永无bug！
 *************************/

import java.io.Serializable;

/**
 * @Auther: DBG_zxx
 * @Date: 2018/11/27 11:47
 * @Desc:
 */
public class User implements Serializable {

    private static final long serialVersionUID = -1776449455777069889L;

    private int id;
    private String name;
    private String age;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
