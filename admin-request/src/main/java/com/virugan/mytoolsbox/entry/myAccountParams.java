package com.virugan.mytoolsbox.entry;

public class myAccountParams {
    private Integer colsNumb;

    private String paraType;

    private String sqlsName;

    private String sqlsValu;

    public Integer getColsNumb() {
        return colsNumb;
    }

    public void setColsNumb(Integer colsNumb) {
        this.colsNumb = colsNumb;
    }

    public String getParaType() {
        return paraType;
    }

    public void setParaType(String paraType) {
        this.paraType = paraType == null ? null : paraType.trim();
    }

    public String getSqlsName() {
        return sqlsName;
    }

    public void setSqlsName(String sqlsName) {
        this.sqlsName = sqlsName == null ? null : sqlsName.trim();
    }

    public String getSqlsValu() {
        return sqlsValu;
    }

    public void setSqlsValu(String sqlsValu) {
        this.sqlsValu = sqlsValu == null ? null : sqlsValu.trim();
    }
}