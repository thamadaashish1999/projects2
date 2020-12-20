package com.example.admin_section;

public class model_charity {

    String charity_name,charityReg,email;

    model_charity(){

    }
    public model_charity(String charity_name, String charityReg, String email ) {
        this.charity_name = charity_name;
        this.charityReg = charityReg;
        this.email = email;
    }

    public String getCharity_name() {
        return charity_name;
    }

    public void setCharity_name(String charity_name) {
        this.charity_name = charity_name;
    }

    public String getCharityReg() {
        return charityReg;
    }

    public void setCharityReg(String charityReg) {
        this.charityReg = charityReg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
