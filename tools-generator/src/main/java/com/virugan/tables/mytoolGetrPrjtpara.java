package com.virugan.tables;

import com.virugan.component.myIndexDepict;
import com.virugan.interfac.myComponent;

import java.util.Arrays;
import java.util.List;

/**
 * 项目参数表
 * mytool_getr_prjtpara
**/
public class mytoolGetrPrjtpara extends myComponent {

    /** 项目名称 **/
    private String belgprjt;
    /** 模块名称 **/
    private String belgmodl;
    /** 数据库驱动 **/
    private String dbdriver;
    /** 数据库用户名 **/
    private String dbusrnme;
    /** 数据库密码 **/
    private String dbpaswrd;
    /** 数据库url **/
    private String dblnkurl;
    /** 项目路径 **/
    private String prjtpath;
    /** 基础词典路径 **/
    private String bscolpth;
    /** 枚举词典路径 **/
    private String bseumpth;
    /** 异常词典路径 **/
    private String excpnpth;
    /** mapper路径 **/
    private String maprpath;
    /** mxml路径 **/
    private String mxmlpath;
    /** entry路径 **/
    private String entypath;

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

    public String getDbdriver() {
        return dbdriver;
    }

    public void setDbdriver(String dbdriver) {
        this.dbdriver = dbdriver;
    }

    public String getDbusrnme() {
        return dbusrnme;
    }

    public void setDbusrnme(String dbusrnme) {
        this.dbusrnme = dbusrnme;
    }

    public String getDbpaswrd() {
        return dbpaswrd;
    }

    public void setDbpaswrd(String dbpaswrd) {
        this.dbpaswrd = dbpaswrd;
    }

    public String getDblnkurl() {
        return dblnkurl;
    }

    public void setDblnkurl(String dblnkurl) {
        this.dblnkurl = dblnkurl;
    }

    public String getPrjtpath() {
        return prjtpath;
    }

    public void setPrjtpath(String prjtpath) {
        this.prjtpath = prjtpath;
    }

    public String getBscolpth() {
        return bscolpth;
    }

    public void setBscolpth(String bscolpth) {
        this.bscolpth = bscolpth;
    }

    public String getBseumpth() {
        return bseumpth;
    }

    public void setBseumpth(String bseumpth) {
        this.bseumpth = bseumpth;
    }

    public String getExcpnpth() {
        return excpnpth;
    }

    public void setExcpnpth(String excpnpth) {
        this.excpnpth = excpnpth;
    }

    public String getMaprpath() {
        return maprpath;
    }

    public void setMaprpath(String maprpath) {
        this.maprpath = maprpath;
    }

    public String getMxmlpath() {
        return mxmlpath;
    }

    public void setMxmlpath(String mxmlpath) {
        this.mxmlpath = mxmlpath;
    }

    public String getEntypath() {
        return entypath;
    }

    public void setEntypath(String entypath) {
        this.entypath = entypath;
    }

    public List<String> getPrimaryKey() {
        return Arrays.asList("belgprjt","belgmodl");
    }

    public String getTableName() {
        return "mytool_getr_prjtpara";
    }

    public myIndexDepict getIndex(String indexid) {
        return null;
    }
}
