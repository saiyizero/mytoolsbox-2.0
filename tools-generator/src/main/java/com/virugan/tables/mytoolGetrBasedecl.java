package com.virugan.tables;

import com.virugan.component.myIndexDepict;
import com.virugan.interfac.myComponent;

import java.util.Arrays;
import java.util.List;
/**
 * 基础字段字典
 * mytool_getr_basedecl
 * **/
public class mytoolGetrBasedecl extends myComponent {

    /*项目名称*/
    private String belgprjt;
    /*模块名称*/
    private String belgmodl;
    /*字段名称*/
    private String colsname;
    /*字段长度*/
    private String colslenh;
    /*字段类型*/
    private String colstype;
    /*字段注释*/
    private String colsccmt;

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

    public String getColsname() {
        return colsname;
    }

    public void setColsname(String colsname) {
        this.colsname = colsname;
    }

    public String getColslenh() {
        return colslenh;
    }

    public void setColslenh(String colslenh) {
        this.colslenh = colslenh;
    }

    public String getColstype() {
        return colstype;
    }

    public void setColstype(String colstype) {
        this.colstype = colstype;
    }

    public String getColsccmt() {
        return colsccmt;
    }

    public void setColsccmt(String colsccmt) {
        this.colsccmt = colsccmt;
    }

    public List<String> getPrimaryKey() {
        return Arrays.asList("belgprjt","belgmodl","colsname");
    }

    public String getTableName() {
        return "mytool_getr_basedecl";
    }

    public myIndexDepict getIndex(String indexid) {
        return null;
    }
}
