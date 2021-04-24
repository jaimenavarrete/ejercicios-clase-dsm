package com.udb.dsm.apilabphp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeopleResponse {
    @SerializedName("success")
    private String success;

    @SerializedName("message")
    private String message;

    @SerializedName("details")
    private List<PeopleInfo> people;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<PeopleInfo> getPeopleInfo() {
        return people;
    }

    public void setPeopleInfo(List<PeopleInfo> peopleInfo) {
        this.people = peopleInfo;
    }
}
