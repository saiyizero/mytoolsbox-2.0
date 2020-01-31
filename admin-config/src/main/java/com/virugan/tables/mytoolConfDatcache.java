package com.virugan.tables;

import com.virugan.component.myIndexDepict;
import com.virugan.interfac.myComponent;

import java.util.Arrays;
import java.util.List;
/**
 * mytool_conf_datcache
 * 本地数据缓存
 * **/
public class mytoolConfDatcache extends myComponent {
    /*缓存名称*/
    private String cachname;
    /*缓存值*/
    private String cachvalu;
    /*缓存类型*/
    private String cachtype;

    public String getCachname() {
        return cachname;
    }

    public void setCachname(String cachname) {
        this.cachname = cachname;
    }

    public String getCachvalu() {
        return cachvalu;
    }

    public void setCachvalu(String cachvalu) {
        this.cachvalu = cachvalu;
    }

    public String getCachtype() {
        return cachtype;
    }

    public void setCachtype(String cachtype) {
        this.cachtype = cachtype;
    }

    public List<String> getPrimaryKey() {
        return Arrays.asList("cachname","cachtype");
    }

    public String getTableName() {
        return "mytool_conf_datcache";
    }

    public myIndexDepict getIndex(String indexid) {
        return null;
    }
}
