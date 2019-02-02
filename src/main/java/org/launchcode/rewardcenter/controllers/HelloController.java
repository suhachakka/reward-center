package org.launchcode.rewardcenter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("reward")
public class HelloController {
    @RequestMapping(value="")
    public String index(){
        return "Hello World";
    }

}
