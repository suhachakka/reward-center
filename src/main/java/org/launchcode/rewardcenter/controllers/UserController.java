package org.launchcode.rewardcenter.controllers;

import org.launchcode.rewardcenter.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", " Sign up");

        return "user/index";
    }
    @RequestMapping(value="signup",method= RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("title","Sign up");
        model.addAttribute(new User());
        return "user/signup";
    }
@RequestMapping(value="signup",method=RequestMethod.POST)
public String add(@ModelAttribute @Valid User user, Errors errors, Model model) {
    if (errors.hasErrors()) {
        //model.addAttribute("user", "user");
        model.addAttribute("name",user.getName());
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("user",user.getPassword());
        model.addAttribute("user",user.getConfirm()) ;
        model.addAttribute("user",user.getEmail());
        model.addAttribute("user",user.getPhone());
        return "user/signup";

    }
        model.addAttribute(new User());
//         model.addAttribute("user",user.getFirstName());
//          model.addAttribute("user",user.getLastName());
//        model.addAttribute("user",user.getPassword());
//        model.addAttribute("user",user.getConfirm()) ;
//       model.addAttribute("user",user.getEmail());
//      model.addAttribute("user",user.getPhone());

          return "list/base";
}
@RequestMapping(value="signin",method=RequestMethod.GET)
    public String addin(Model model){
        model.addAttribute("user","user");
        return "user/signin";
}
}
