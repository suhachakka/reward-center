package org.launchcode.rewardcenter.controllers;

import org.launchcode.rewardcenter.models.ResetPw;
import org.launchcode.rewardcenter.models.SignUser;
import org.launchcode.rewardcenter.models.User;
import org.launchcode.rewardcenter.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "") /* It provides list of employees in model object */
    public String index(Model model) {
        model.addAttribute("users", userDao.findAll());
        return "user/index";

    }

    /**
     * It displays a form to input data, here "users" is a reserved request attribute
     * which is used to display object data into form
     */

    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public String displayUserForm(Model model) {
        model.addAttribute("title", "Sign up");
        model.addAttribute(new User());
        model.addAttribute("users", userDao.findAll());
        return "user/signup";
    }

    /**
     * It saves object into database. The @ModelAttribute puts request data
     * into model object. You need to mention RequestMethod.POST method
     * because default request is GET
     */

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String processUserForm(@ModelAttribute @Valid User user, Errors errors,
                                  Model model, HttpSession session) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Sign up");
            return "user/signup";
        }
        User existUser = userDao.findByEmail(user.getEmail());
        User existPuser = userDao.findByPhone(user.getPhone());
        if (existUser != null || existPuser != null) {
//          model.addAttribute("disMsg","User already exists");
//            return "user/signup";
            return "redirect:/user/signup?q=User+already+exists";
       }

//        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userDao.save(user);
        session.setAttribute("username", user.getName());
        session.setAttribute("sUserId",user.getId());
//        return "redirect:";
        return "user/welcome";
    }


    /**
     * It deletes record for the given id in URL and redirects to /index
     */

    @RequestMapping(value = "delete/{userId}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable int userId, Model model) {
        User user = userDao.findById(userId).get();
        userDao.delete(user);
        model.addAttribute("users", userDao.findAll());
        return "user/index";

    }

    /**
     * It displays object data into form for the given id.
     * The @PathVariable puts URL data into variable.
     */

    @RequestMapping(value = "edit/{userId}", method = RequestMethod.GET)
    public String editDisplayForm(@PathVariable int userId, Model model) {
        model.addAttribute("user", userDao.findById(userId));
        model.addAttribute("users", userDao.findAll());
        return "user/edit";

    }


    /**
     * It updates model object.
     */

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String editProcessForm(@RequestParam int userId, @RequestParam String name, @RequestParam String lastName, @RequestParam String password,
                                  @RequestParam String confirm, @RequestParam String sec_question,
                                  @RequestParam String email, @RequestParam String phone, Model model) {
        User user = userDao.findById(userId).get();
        user.setName(name);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setConfirm(confirm);
        user.setEmail(email);
        user.setPhone(phone);
        user.setSec_question(sec_question);
        userDao.save(user);
        return "redirect:"; /*will redirect to view users  index page request mapping*/
    }

//    @RequestMapping(value="search", method=RequestMethod.GET)
//    public String displaySearchForm(@RequestParam String keyword, User user,Model model){
//        model.addAttribute("title","Search by:" +user.getKeyword());
//        userDao.searchByKeyword(keyword);
//        return "user/search";
//    }

    @RequestMapping(value = "signin", method = RequestMethod.GET)
    public String displayLoginForm(Model model) {
        model.addAttribute("title", "Sign in form");
        model.addAttribute("signUser", new SignUser());
        return "user/signin";
    }

    @RequestMapping(value = "signin", method = RequestMethod.POST)
    public String processLoginForm(@ModelAttribute @Valid SignUser signUser, Errors errors, Model model, HttpSession session) {

//        if (!signUser.getEmail().isEmpty() && !signUser.getPassword().isEmpty()) {
        if (errors.hasErrors()) {
            return "user/signin";
        }
        User matchUser;
        matchUser = userDao.findByEmail(signUser.getEmail());
        if (matchUser == null) {
            matchUser = userDao.findByPhone(signUser.getEmail());
        }
        if (matchUser != null && signUser.getPassword().equals(matchUser.getPassword())) {
            session.setAttribute("username", matchUser.getName() + " " + matchUser.getLastName());
            session.setAttribute("sUserId",matchUser.getId());
            return "user/welcome";
        }
        model.addAttribute("message", "Invalid Credentials");
        return "redirect:/user/signin?q=Invalid+Credentials";

//        return "redirect:";

    }

    @RequestMapping(value = "signout", method = RequestMethod.GET)
    public String processLogoutForm(HttpSession session) {
        session.removeAttribute("username");
        session.removeAttribute("sUserId");
        return "user/signout";
    }

    @RequestMapping(value = "base", method = RequestMethod.GET)
    public String welcomePage() {
        return "user/welcome";
    }


    @RequestMapping(value = "recovery", method = RequestMethod.GET)
    public String displayRecoverPassword(Model model) {
       model.addAttribute("title","Reset Password");
       model.addAttribute(new ResetPw());
        return "user/recovery";
    }
    @RequestMapping(value = "recovery", method = RequestMethod.POST)
    public String processRecoverPassword(@ModelAttribute @Valid ResetPw resetPw,Errors errors,
                                         @RequestParam String password,
                                         @RequestParam String confirm,
                                          Model model,HttpSession session) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Reset Password");
            return "user/recovery";
        }
        User existUser;
        existUser = userDao.findByEmail(resetPw.getEmail());
        if (existUser == null) {
            return "redirect:/user/recovery?q=Invalid+Email";
        }

        if (existUser.getSec_question().equals(resetPw.getSec_question())) {
            existUser.setPassword(password);
            existUser.setConfirm(confirm);
            userDao.save(existUser);
            session.setAttribute("username", existUser.getName() + " " + existUser.getLastName());
            session.setAttribute("sUserId",existUser.getId());
            return "user/welcome";
        } else {
//         model.addAttribute("message", "Invalid security answer");
            return "redirect:/user/recovery?Q=Invalid+Security+answer";
        }
    }
    @RequestMapping(value = "search",method = RequestMethod.GET)
    public String search(Model model,@RequestParam String keyword){
      User searchUser = userDao.findByKeyword(keyword);
        if(keyword.equals(searchUser)){
            model.addAttribute("searchUser",searchUser);
            return "user/index";
        }
        return "user/search";
    }

}