package com.example.admin_section;

public class signup_save_data_in_fire {
    String admin_firstname,admin_lastname,admin_phone,admin_email,admin_username,admin_password;

    public signup_save_data_in_fire() {

    }

    public signup_save_data_in_fire(String admin_firstname, String admin_lastname, String admin_phone, String admin_email, String admin_username, String admin_password) {
        this.admin_firstname = admin_firstname;
        this.admin_lastname = admin_lastname;
        this.admin_phone = admin_phone;
        this.admin_email = admin_email;
        this.admin_username = admin_username;
        this.admin_password = admin_password;
    }

    public String getAdmin_firstname() {
        return admin_firstname;
    }

    public void setAdmin_firstname(String admin_firstname) {
        this.admin_firstname = admin_firstname;
    }

    public String getAdmin_lastname() {
        return admin_lastname;
    }

    public void setAdmin_lastname(String admin_lastname) {
        this.admin_lastname = admin_lastname;
    }

    public String getAdmin_phone() {
        return admin_phone;
    }

    public void setAdmin_phone(String admin_phone) {
        this.admin_phone = admin_phone;
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }

    public String getAdmin_username() {
        return admin_username;
    }

    public void setAdmin_username(String admin_username) {
        this.admin_username = admin_username;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }
}
