package com.example.admin_section;

public class model_donor {

    String donor_name,profession,email,image,password,phone,status,thumb_image;

    model_donor(){

    }

    public model_donor(String donor_name, String profession, String email,String image,String password,String phone,String status,String thumb_image ) {
        this.donor_name = donor_name;
        this.profession = profession;
        this.email = email;
        this.image=image;
        this.password=password;
        this.phone=phone;
        this.status=status;
        this.thumb_image=thumb_image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getThumb_image() {
        return thumb_image;
    }

    public void setThumb_image(String thumb_image) {
        this.thumb_image = thumb_image;
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
