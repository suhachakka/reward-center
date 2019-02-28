package org.launchcode.rewardcenter.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "MY_SEQUENCE", allocationSize = 1)

public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private int id;

    @NotNull
    @Size(min=1,max=15)
    private String deptName;

    @NotNull
    @Size(min=1,max=50)
    private String description;

    public Department(){

    }

    public Department(String deptName, String description) {
        this.deptName = deptName;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
