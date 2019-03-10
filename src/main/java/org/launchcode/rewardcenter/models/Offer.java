package org.launchcode.rewardcenter.models;
import org.hibernate.annotations.GenericGenerator;
import org.launchcode.rewardcenter.models.Card;
import org.launchcode.rewardcenter.models.Category;
import org.launchcode.rewardcenter.models.Department;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name="native",strategy = "native")
    //@GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

    @NumberFormat
    private double qualified_amt;

    @NotNull
    private double cashBack ;

    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    private String ExpiryDate;

    @NotNull
    private String CouponCode;

    @NotNull
    private String cashMode;

    private int totalPages;

    private int userId;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Department department;

    @ManyToOne
    private Card card;

    public Offer() {

    }

    public Offer(@NotNull double qualified_amt, @NotNull(message = "please enter the cash") double cashBack,
                 String expiryDate, @NotNull String couponCode, @NotNull String cashMode,
                 Category category, Department department, Card card,int totalPages) {
        this.qualified_amt = qualified_amt;
        this.cashBack = cashBack;
        ExpiryDate = expiryDate;
        CouponCode = couponCode;
        this.cashMode = cashMode;
        this.category = category;
        this.department = department;
        this.card = card;
        this.totalPages =totalPages;
    }


    public int getId() {
        return id;
    }

    public double getQualified_amt() {
        return qualified_amt;
    }

    public void setQualified_amt(double qualified_amt) {
        this.qualified_amt = qualified_amt;
    }




    public String getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        ExpiryDate = expiryDate;
    }

    public String getCouponCode() {
        return CouponCode;
    }

    public void setCouponCode(String couponCode) {
        CouponCode = couponCode;
        codevalue();
    }


    public double getCashBack() {

        return cashBack;
    }

    public void setCashBack(double cashBack) {
        this.cashBack = cashBack;

    }

    public String getCashMode() {
       return cashMode;
    }

    public void setCashMode(String cashMode) {
        this.cashMode = cashMode;

    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public int getTotalPages(){
        return totalPages;
    }
    public void setTotalPages(int totalPages){
        this.totalPages=totalPages;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "qualified_amt=" + qualified_amt +
                ", cashBack=" + cashBack +
                ", ExpiryDate=" + ExpiryDate +
                ", CouponCode='" + CouponCode + '\'' +
                ", cashMode='" + cashMode + '\'' +
                ", category=" + category +
                ", department=" + department +
                ", card=" + card +
                '}';
    }


   public String codevalue(){
        if(CouponCode == "" || CouponCode==null){
            return "none";
        }
        return CouponCode;
   }

      }

