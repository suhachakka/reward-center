package org.launchcode.rewardcenter.models;


import org.hibernate.annotations.GenericGenerator;
import org.launchcode.rewardcenter.models.Offer;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name="native",strategy = "native")
    private int id;

    @NotNull
    @Size(min = 1, max = 20)
    private String categoryName;

    private boolean deptAllowed;

//    @OneToOne
//    @JoinColumn(name = "dept_id")
//   List<Offer> offers= new ArrayList<>();
//    private Department department;

    public Category() {

    }

    public Category(String categoryName, boolean deptAllowed) {
        this.categoryName = categoryName;
        this.deptAllowed = deptAllowed;
    }

    public int getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isDeptAllowed() {
        return deptAllowed;
    }

    public void setDeptAllowed(boolean deptAllowed) {
        this.deptAllowed = deptAllowed;
    }

//    public Department getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(Department department) {
//        this.department = department;
//    }
    //    public List<Offer> getOffers() {
//        return offers;
//    }
//
//    public void setOffers(List<Offer> offers) {
//        this.offers = offers;
//    }


    }




