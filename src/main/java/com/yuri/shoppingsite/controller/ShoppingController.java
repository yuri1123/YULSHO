package com.yuri.shoppingsite.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShoppingController {
    @GetMapping("shopping/shopping")
    public void shopProducts(){

    }

}
