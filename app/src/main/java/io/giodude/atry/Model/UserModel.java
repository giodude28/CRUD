package io.giodude.atry.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {

    @SerializedName("UserID")
    @Expose
    private Integer id;
    @SerializedName("Firstname")
    @Expose
    private String fname;
    @SerializedName("Middlename")
    @Expose
    private String mname;
    @SerializedName("Lastname")
    @Expose
    private String lname;

    public UserModel(Integer id, String fname, String mname, String lname) {
        this.id = id;
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
    }

    public Integer getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getMname() {
        return mname;
    }

    public String getLname() {
        return lname;
    }
}
