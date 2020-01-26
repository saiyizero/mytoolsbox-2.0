package com.virugan.tables;

import com.virugan.component.myIndexDepict;
import com.virugan.interfac.myComponent;

import java.util.Arrays;
import java.util.List;

public class mytoolGetrEumdetil extends myComponent {

    /** 项目名称 **/
    private String belgprjt;
    /** 模块名称 **/
    private String belgmodl;
    /** 枚举字段 **/
    private String enumcols;
    /** 枚举声明 **/
    private String enumstat;
    /** 枚举值描述 **/
    private String valudesc;
    /** 枚举值 **/
    private String enumvalu;

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

    public String getEnumcols() {
        return enumcols;
    }

    public void setEnumcols(String enumcols) {
        this.enumcols = enumcols;
    }

    public String getEnumstat() {
        return enumstat;
    }

    public void setEnumstat(String enumstat) {
        this.enumstat = enumstat;
    }

    public String getValudesc() {
        return valudesc;
    }

    public void setValudesc(String valudesc) {
        this.valudesc = valudesc;
    }

    public String getEnumvalu() {
        return enumvalu;
    }

    public void setEnumvalu(String enumvalu) {
        this.enumvalu = enumvalu;
    }

    public List<String> getPrimaryKey() {
        return Arrays.asList("belgprjt","belgmodl","enumcols","enumstat");
    }
    public String getTableName() {
        return "mytool_getr_eumdetil";
    }
    public myIndexDepict getIndex(String indexid) {
        return null;
    }
}
