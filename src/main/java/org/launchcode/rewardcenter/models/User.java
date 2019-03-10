package org.launchcode.rewardcenter.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name="native",strategy = "native")
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

    @NotNull(message = "Passwords do not match")
    @Transient
    private String confirm;

    @Email
    @Size(min=10,max=25)
    private String email;

    @NotNull
    @Pattern(regexp="\\(\\d{3}\\)\\d{3}-\\d{4}",message="phone number must be (123)456-7890 format")
//    @Size(min=10)
    private String phone;


    private String sec_question;

    public User() {

    }
    public User(String name,String lastName,String password, String confirm,
                String email, String phone,String sec_question){
        this.name = name;
        this.lastName =lastName;
        this.password =password;
        this.confirm = confirm;
        this.email= email;
        this.phone = phone;
        this.sec_question=sec_question;
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


    public String getSec_question() {
        return sec_question;
    }

    public void setSec_question(String sec_question) {
        this.sec_question = sec_question;
    }

    private void checkPassword(){
        if (confirm != null && password != null && !password.equals( confirm)){
                confirm = null;
            }
    }



    }

