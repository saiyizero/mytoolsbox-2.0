package com.virugan.tables;

import com.virugan.component.myIndexDepict;
import com.virugan.interfac.myComponent;

import java.util.Arrays;
import java.util.List;

/**
 * 表结构登记表
 * mytool_getr_tabregtr
 * **/
public class mytoolGetrTabregtr extends myComponent {

    /*项目名称*/
    private String belgprjt;
    /*模块名称*/
    private String belgmodl;
    /*表名称*/
    private String tablname;
    /*表注释*/
    private String tablcomt;

    public String getBelgprjt() {
        return belgprjt;
    }

    public void setBelgprjt(String belgprjt) {
        this.belgprjt = belgprjt;
    }

    public String getBelgmodl() {
        return belgmodl;
    }

    public void setBelgmodl(String belgmodl) {
        this.belgmodl = belgmodl;
    }

    public String getTablname() {
        return tablname;
    }

    public void setTablname(String tablname) {
        this.tablname = tablname;
    }

    public String getTablcomt() {
        return tablcomt;
    }

    public void setTablcomt(String tablcomt) {
        this.tablcomt = tablcomt;
    }

    public List<String> getPrimaryKey() {
        return Arrays.asList("tablname","belgprjt","belgmodl");
    }

    public String getTableName() {
        return "mytool_getr_tabregtr";
    }

    public myIndexDepict getIndex(String indexid) {
        return null;
    }
}
