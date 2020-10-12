package model;

import com.google.gson.annotations.SerializedName;

public class SearchConditions {
    @SerializedName("java")
    private String java;

    @SerializedName("startDate")
    private String startDate;

    @SerializedName("endDate")
    private String endDate;

    @SerializedName("startPrice")
    private String startPrice;

    @SerializedName("endPrice")
    private String endPrice;

    @SerializedName("note")
    private String note;

    @SerializedName("inforSkill")
    private String inforSkill;


    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getStartPrice() {
        return startPrice;
    }

    public String getEndPrice() {
        return endPrice;
    }

    public String getNote() {
        return note;
    }

    public String getInforSkill() {
        return inforSkill;
    }

    public String getJava() {
        return java;
    }
}
