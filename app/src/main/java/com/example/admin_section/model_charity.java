package com.example.admin_section;

public class model_charity {

    String charity_name,charityReg,email,charity_address,description,image,password,phone,post_description,post_image,requirements,status,thumb_image;;

    model_charity(){

    }
    public model_charity(String charity_name, String charityReg, String email,String charity_adderss,String description,String image,String password,String phone,
                         String post_description,String post_image,String requirements,String status,String thumb_image ) {

        this.charity_name = charity_name;
        this.charityReg = charityReg;
        this.email = email;
        this.charity_address = charity_adderss;
        this.description=description;
        this.image=image;
        this.password=password;
        this.phone=phone;
        this.post_description=post_description;
        this.post_image=post_image;
        this.requirements=requirements;
        this.status=status;
        this.thumb_image=thumb_image;
    }

    public String getCharity_address() {
        return charity_address;
    }

    public void setCharity_address(String charity_address) {
        this.charity_address = charity_address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getPost_description() {
        return post_description;
    }

    public void setPost_description(String post_description) {
        this.post_description = post_description;
    }

    public String getPost_image() {
        return post_image;
    }

    public void setPost_image(String post_image) {
        this.post_image = post_image;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
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
