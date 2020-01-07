package com.virugan.mytoolsbox.entry;

public class myaccountAuodil {
    private Integer colsNumb;

    private String starDate;

    private String tendDate;

    private String tranGood;

    private String tranDict;

    private Double tranAmts;

    private String itemType;

    private String gropType;

    public Integer getColsNumb() {
        return colsNumb;
    }

    public void setColsNumb(Integer colsNumb) {
        this.colsNumb = colsNumb;
    }

    public String getStarDate() {
        return starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate == null ? null : starDate.trim();
    }

    public String getTendDate() {
        return tendDate;
    }

    public void setTendDate(String tendDate) {
        this.tendDate = tendDate == null ? null : tendDate.trim();
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