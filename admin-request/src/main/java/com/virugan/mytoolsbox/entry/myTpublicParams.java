package com.virugan.mytoolsbox.entry;

public class myTpublicParams {
    private String paraName;

    private String paraValu;

    private String paraType;

    public String getParaName() {
        return paraName;
    }

    public void setParaName(String paraName) {
        this.paraName = paraName == null ? null : paraName.trim();
    }

    public String getParaValu() {
        return paraValu;
    }

    public void setParaValu(String paraValu) {
        this.paraValu = paraValu == null ? null : paraValu.trim();
    }

    public String getParaType() {
        return paraType;
    }

    public void setParaType(String paraType) {
        this.paraType = paraType == null ? null : paraType.trim();
    }
}