package org.launchcode.rewardcenter.controllers;

import org.launchcode.rewardcenter.models.Department;
import org.launchcode.rewardcenter.models.data.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("title","Department Info");
        model.addAttribute("departments",departmentDao.findAll());
        return "department/view";
    }

    @RequestMapping(value="addepartment",method= RequestMethod.GET)
    public String displayDepartmentForm(Model model){
        model.addAttribute("title","Departments");
        model.addAttribute(new Department());
        model.addAttribute("departments",departmentDao.findAll());
        return "department/addepartment";
    }

    @RequestMapping(value="addepartment",method=RequestMethod.POST)
    public String processDeparmentForm(@ModelAttribute @Valid Department department, Errors errors){
        if(errors.hasErrors()){
            return "department/addepartment";
        }
        departmentDao.save(department);
        return "redirect:";
    }

    @RequestMapping(value="edit/{deptId}",method=RequestMethod.GET)
    public String displayEditForm(@PathVariable int deptId, Model model){
        model.addAttribute("title","Update the Department Info");
        Department department=departmentDao.findById(deptId).get();
        model.addAttribute("department",department);
        model.addAttribute("departments",departmentDao.findAll());
        return "department/edit";

    }

    @RequestMapping(value="edit",method=RequestMethod.POST)
    public String ProcessEditForm(@RequestParam int deptId,@RequestParam String deptName,
                         @RequestParam String description){

        Department department=departmentDao.findById(deptId).get();
        department.setDeptName(deptName);
        department.setDescription(description);
        departmentDao.save(department);
        return "redirect:";

    }
    @RequestMapping(value="delete/{deptId}",method=RequestMethod.GET)
    public String deleteDepartmentForm(@PathVariable int deptId, Model model){
        Department department=departmentDao.findById(deptId).get();
        departmentDao.delete(department);
        model.addAttribute("departments",departmentDao.findAll());
        return "department/view";

    }
    @RequestMapping(value="search/{deptId}",method=RequestMethod.GET)
    public String displaySearchForm(@PathVariable int deptId, Model model){
        model.addAttribute("title","Search by id");
        Department department=departmentDao.findById(deptId).get();
        model.addAttribute("department",department);
        departmentDao.existsById(deptId);
        model.addAttribute("departments",departmentDao.findAll());
        return "department/search";

    }
}
