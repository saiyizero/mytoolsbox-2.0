package com.virugan.tables;

import com.virugan.component.myIndexDepict;
import com.virugan.interfac.myComponent;

import java.util.Arrays;
import java.util.List;

/**
  * 基础枚举字典
 * */
public class mytoolGetrEnumdict extends myComponent {
    /** 项目名称 **/
    private String belgprjt;
    /** 模块名称 **/
    private String belgmodl;
    /** 枚举字段 **/
    private String enumcols;
    /** 枚举注释 **/
    private String enumname;

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

    public String getEnumname() {
        return enumname;
    }

    public void setEnumname(String enumname) {
        this.enumname = enumname;
    }

    public List<String> getPrimaryKey() {
        return Arrays.asList("belgprjt","belgmodl","enumcols");
    }

    public String getTableName() {
        return "mytool_getr_enumdict";
    }

    public myIndexDepict getIndex(String indexid) {
        return null;
    }
}
