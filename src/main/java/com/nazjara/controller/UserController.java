package com.nazjara.controller;

import com.nazjara.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"", "/", "/index"})
    public String index(){
        return "index";
    }

    @PostMapping("/users")
    public String formPost(Model model, ServerWebExchange serverWebExchange){

        MultiValueMap<String, String> map = serverWebExchange.getFormData().block();

        Integer limit = new Integer(map.get("limit").get(0));

        //default if null or zero
        if(limit == null || limit == 0){
            limit = 10;
        }

        model.addAttribute("users", userService.getUsers(limit).getData());

        return "userlist";
    }
}