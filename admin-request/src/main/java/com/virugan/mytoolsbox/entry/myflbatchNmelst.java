package com.virugan.mytoolsbox.entry;

public class myflbatchNmelst {
    private String gropName;

    private String suffName;

    private String gropType;

    public String getGropName() {
        return gropName;
    }

    public void setGropName(String gropName) {
        this.gropName = gropName == null ? null : gropName.trim();
    }

    public String getSuffName() {
        return suffName;
    }

    public void setSuffName(String suffName) {
        this.suffName = suffName == null ? null : suffName.trim();
    }

    public String getGropType() {
        return gropType;
    }

    public void setGropType(String gropType) {
        this.gropType = gropType == null ? null : gropType.trim();
    }
}