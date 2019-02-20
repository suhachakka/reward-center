package org.launchcode.rewardcenter.models;


import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PatchMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Entity
public class Category {

   @Id
   @GeneratedValue
   private int id;

   @NotNull
   @Size(min=1,max=20)
   private String categoryName;

   private boolean deptAllowed;

   public Category(){

   }

    public Category(String categoryName,  boolean deptAllowed) {
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

}
