package com.example.admin_section;

public class model_donor {

    String donor_name,profession,email;

    model_donor(){

    }

    public model_donor(String donor_name, String profession, String email) {
        this.donor_name = donor_name;
        this.profession = profession;
        this.email = email;
    }

    public String getDonor_name() {
        return donor_name;
    }

    public void setDonor_name(String donor_name) {
        this.donor_name = donor_name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
