package com.virugan.tables;

import com.virugan.component.myIndexDepict;
import com.virugan.interfac.myComponent;

import java.util.Arrays;
import java.util.List;

/**
 * 创建表字典
 * mytool_getr_tabcsant
 * **/
public class mytoolGetrTabcsant extends myComponent {
    /*项目名称*/
    private String belgprjt;
    /*模块名称*/
    private String belgmodl;
    /*表名称*/
    private String tablname;
    /*表注释*/
    private String tablcomt;
    /*表字段名称*/
    private String tablcols;
    /*表字段注释*/
    private String tablccmt;
    /*是否允许未空*/
    private String ifnonull;
    /*默认值*/
    private String defltval;
    /*主键索引类型*/
    private String indextyp;
    /*索引名称*/
    private String indexnme;

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

    public String getTablcols() {
        return tablcols;
    }

    public void setTablcols(String tablcols) {
        this.tablcols = tablcols;
    }

    public String getTablccmt() {
        return tablccmt;
    }

    public void setTablccmt(String tablccmt) {
        this.tablccmt = tablccmt;
    }

    public String getIfnonull() {
        return ifnonull;
    }

    public void setIfnonull(String ifnonull) {
        this.ifnonull = ifnonull;
    }

    public String getDefltval() {
        return defltval;
    }

    public void setDefltval(String defltval) {
        this.defltval = defltval;
    }

    public String getIndextyp() {
        return indextyp;
    }

    public void setIndextyp(String indextyp) {
        this.indextyp = indextyp;
    }

    public String getIndexnme() {
        return indexnme;
    }

    public void setIndexnme(String indexnme) {
        this.indexnme = indexnme;
    }
    public List<String> getPrimaryKey() {
        return Arrays.asList("tablname","tablcols");
    }

    public String getTableName() {
        return "mytool_getr_tabcsant";
    }

    public myIndexDepict getIndex(String indexid) {
        return null;
    }
}
