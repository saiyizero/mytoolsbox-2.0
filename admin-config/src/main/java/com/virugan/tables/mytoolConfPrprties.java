package com.virugan.tables;

import com.virugan.component.myIndexDepict;
import com.virugan.interfac.myComponent;

import java.util.Arrays;
import java.util.List;

/**
 * 项目配置信息表
 * mytool_conf_prprties
 * **/
public class mytoolConfPrprties extends myComponent {
    /*模块名称*/
    private String belgmodl;
    /*参数名称*/
    private String cansunme;
    /*参数值*/
    private String cansuval;

    public String getBelgmodl() {
        return belgmodl;
    }

    public void setBelgmodl(String belgmodl) {
        this.belgmodl = belgmodl;
    }

    public String getCansunme() {
        return cansunme;
    }

    public void setCansunme(String cansunme) {
        this.cansunme = cansunme;
    }

    public String getCansuval() {
        return cansuval;
    }

    public void setCansuval(String cansuval) {
        this.cansuval = cansuval;
    }

    public List<String> getPrimaryKey() {
        return Arrays.asList("belgmodl","cansunme");
    }

    public String getTableName() {
        return "mytool_conf_prprties";
    }

    public myIndexDepict getIndex(String indexid) {
        return null;
    }
}
