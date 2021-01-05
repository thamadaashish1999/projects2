package com.example.admin_section;

public class firebase_store {
    String admfirst,admlast,admphone,admpassword,admusername,admemail;

    public firebase_store(String admfirst, String admlast, String admphone, String admpassword, String admusername, String admemail) {

    }

    public String getAdmfirst() {
        return admfirst;
    }

    public void setAdmfirst(String admfirst) {
        this.admfirst = admfirst;
    }

    public String getAdmlast() {
        return admlast;
    }

    public void setAdmlast(String admlast) {
        this.admlast = admlast;
    }

    public String getAdmphone() {
        return admphone;
    }

    public void setAdmphone(String admphone) {
        this.admphone = admphone;
    }

    public String getAdmpassword() {
        return admpassword;
    }

    public void setAdmpassword(String admpassword) {
        this.admpassword = admpassword;
    }

    public String getAdmusername() {
        return admusername;
    }

    public void setAdmusername(String admusername) {
        this.admusername = admusername;
    }

    public String getAdmemail() {
        return admemail;
    }

    public void setAdmemail(String admemail) {
        this.admemail = admemail;
    }
}
