package org.launchcode.rewardcenter.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ResetPw {

    @Email
    @Size(min=10,max=25)
    private String email;

    @NotEmpty
    @Size(min=5,max=10)
    private String password;

    @NotNull(message = "Passwords do not match")
    private String confirm;

    @NotEmpty
    private String sec_question;

    public ResetPw(){

    }

    public ResetPw(String email, String password, String confirm,
                   String sec_question) {
        this.email = email;
        this.password = password;
        this.confirm = confirm;
        this.sec_question = sec_question;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
        checkPassword();
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
