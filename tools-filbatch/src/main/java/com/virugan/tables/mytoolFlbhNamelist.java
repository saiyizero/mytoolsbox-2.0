package com.virugan.tables;

import com.virugan.component.myIndexDepict;
import com.virugan.interfac.myComponent;

import java.util.List;

public class mytoolFlbhNamelist extends myComponent {

    private String gropname;

    private String suffname;

    private String gropType;

    public String getGropName() {
        return gropname;
    }

    public void setGropName(String gropName) {
        this.gropname = gropName == null ? null : gropName.trim();
    }

    public String getSuffName() {
        return suffname;
    }

    public void setSuffName(String suffName) {
        this.suffname = suffName == null ? null : suffName.trim();
    }

    public String getGropType() {
        return gropType;
    }

    public void setGropType(String gropType) {
        this.gropType = gropType == null ? null : gropType.trim();
    }

    public List<String> getPrimaryKey() {
        return null;
    }

    public String getTableName() {
        return null;
    }

    public myIndexDepict getIndex(String indexid) {
        return null;
    }
}