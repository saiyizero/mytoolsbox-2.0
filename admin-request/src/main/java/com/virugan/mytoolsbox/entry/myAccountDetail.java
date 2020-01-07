package com.virugan.mytoolsbox.entry;

public class myAccountDetail {
    private Integer colsNumb;

    private String fileName;

    private String fileType;

    private String tranDate;

    private String tranTime;

    private String tranType;

    private String tranObjt;

    private String tranGood;

    private String tranDict;

    private Double tranAmts;

    private String paytNums;

    private String tranFlag;

    private String tranNumb;

    private String objtNumb;

    private String itemType;

    private String gropType;

    public Integer getColsNumb() {
        return colsNumb;
    }

    public void setColsNumb(Integer colsNumb) {
        this.colsNumb = colsNumb;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public String getTranDate() {
        return tranDate;
    }

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate == null ? null : tranDate.trim();
    }

    public String getTranTime() {
        return tranTime;
    }

    public void setTranTime(String tranTime) {
        this.tranTime = tranTime == null ? null : tranTime.trim();
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType == null ? null : tranType.trim();
    }

    public String getTranObjt() {
        return tranObjt;
    }

    public void setTranObjt(String tranObjt) {
        this.tranObjt = tranObjt == null ? null : tranObjt.trim();
    }

    public String getTranGood() {
        return tranGood;
    }

    public void setTranGood(String tranGood) {
        this.tranGood = tranGood == null ? null : tranGood.trim();
    }

    public String getTranDict() {
        return tranDict;
    }

    public void setTranDict(String tranDict) {
        this.tranDict = tranDict == null ? null : tranDict.trim();
    }

    public Double getTranAmts() {
        return tranAmts;
    }

    public void setTranAmts(Double tranAmts) {
        this.tranAmts = tranAmts;
    }

    public String getPaytNums() {
        return paytNums;
    }

    public void setPaytNums(String paytNums) {
        this.paytNums = paytNums == null ? null : paytNums.trim();
    }

    public String getTranFlag() {
        return tranFlag;
    }

    public void setTranFlag(String tranFlag) {
        this.tranFlag = tranFlag == null ? null : tranFlag.trim();
    }

    public String getTranNumb() {
        return tranNumb;
    }

    public void setTranNumb(String tranNumb) {
        this.tranNumb = tranNumb == null ? null : tranNumb.trim();
    }

    public String getObjtNumb() {
        return objtNumb;
    }

    public void setObjtNumb(String objtNumb) {
        this.objtNumb = objtNumb == null ? null : objtNumb.trim();
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType == null ? null : itemType.trim();
    }

    public String getGropType() {
        return gropType;
    }

    public void setGropType(String gropType) {
        this.gropType = gropType == null ? null : gropType.trim();
    }
}