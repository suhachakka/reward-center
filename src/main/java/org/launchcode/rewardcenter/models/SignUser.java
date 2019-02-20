package org.launchcode.rewardcenter.models;

import javax.validation.constraints.*;

public class SignUser {

    @NotEmpty(message="Please enter the Email or Phone")
//    @Email
//    @Pattern(regexp="\\(\\d{3}\\)\\d{3}-\\d{4}")
    private String email;
    //private int phone;

    @NotBlank(message="Please enter the password")
    private String password;

public SignUser() {

}

    public SignUser(@NotNull String email,  @NotNull String password) {
        this.email = email;
        //this.phone = phone;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public int getPhone() {
//        return phone;
//    }
//
//    public void setPhone(int phone) {
//        this.phone = phone;
   // }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void checkValidation(){


    }
}