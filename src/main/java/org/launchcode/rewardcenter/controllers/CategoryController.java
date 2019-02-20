package org.launchcode.rewardcenter.controllers;

import org.launchcode.rewardcenter.models.Category;
import org.launchcode.rewardcenter.models.data.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("title","Category");
        model.addAttribute("categories",categoryDao.findAll());
       return "category/view";
    }

    @RequestMapping(value="addcategory",method=RequestMethod.GET)
    public String processAddcategory(Model model){
        model.addAttribute("title","Category");
        model.addAttribute(new Category());
        model.addAttribute("categories",categoryDao.findAll());
        return "category/addcategory";
    }

    @RequestMapping(value="addcategory",method= RequestMethod.POST)
    public String displayAddcategory(@ModelAttribute @Valid Category category, Errors errors,Model model){
        if(errors.hasErrors()){
            return "category/addcategory";
        }
        categoryDao.save(category);
        return "redirect:";
    }
    @RequestMapping(value = "delete/{categoryId}", method = RequestMethod.GET)
    public String deleteCardRecord(@PathVariable int categoryId, Model model) {
        Category category = categoryDao.findById(categoryId).get();
        categoryDao.delete(category);
        model.addAttribute("categories", categoryDao.findAll());

        return "category/view";

    }

    @RequestMapping(value = "edit/{categoryId}", method = RequestMethod.GET)
    public String diasplayEditForm( @PathVariable int categoryId,Model model) {
        model.addAttribute("title", " Update the info");
        model.addAttribute("category",categoryDao.findById(categoryId));
        model.addAttribute("categories", categoryDao.findAll());
        return "category/edit";
    }

    @RequestMapping(value="edit",method = RequestMethod.POST)
    public String processEditForm(@RequestParam int categoryId,
                                  @RequestParam String categoryName,
                                  @RequestParam boolean deptAllowed){

        Category category =categoryDao.findById(categoryId).get();
        category.setCategoryName(categoryName);
        category.setDeptAllowed(deptAllowed);


        categoryDao.save(category);
        return "redirect:";

    }


}
