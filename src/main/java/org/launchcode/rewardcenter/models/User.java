package org.launchcode.rewardcenter.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//@Entity
public class User {

//    @Id
//    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=5,max=20)
    private String name;

    @NotNull
    @Size(min=5,max=20)
    private String lastName;

    @NotNull
    @Size(min=5,max=10)
    private String password;

    @NotNull
    @Size(message = "Passwords do not match")
    private String confirm;

    @Email
    @Size(min=10,max=25)
    private String email;

    @NotNull
    @Size(min=3,max=10)
    private String phone;

    public User() {

    }
    public User(String name,String lastName,String password, String confirm, String email, String phone){
        this.name = name;
        this.lastName =lastName;
        this.password =password;
        this.confirm = confirm;
        this.email= email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getPassword() {
        return password;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
        checkPassword();
    }
    public String getConfirm() {
        return confirm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private void checkPassword(){
        if (confirm != null && password != null && !password.equals( confirm)){
                confirm = null;
            }
    }
}
