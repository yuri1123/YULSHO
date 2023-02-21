package com.yuri.shoppingsite.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
@RequiredArgsConstructor
public class AdminController {

    //상품 관리 페이지로 가기리스트)
    @GetMapping("admin/productlist")
    public String manProducts() {
        return "/admin/productlist";
    }

    //상품 등록 페이지로 가기(insert)
    @GetMapping("admin/uploadproduct")
    public void uploadProductsP() {
    }




}
