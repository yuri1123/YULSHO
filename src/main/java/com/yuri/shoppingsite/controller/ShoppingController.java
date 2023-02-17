package com.yuri.shoppingsite.controller;

import com.yuri.shoppingsite.service.ProductService;
import com.yuri.shoppingsite.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@Controller
public class ShoppingController {


    private ProductService productService;


    //상품 전체 보여주기 리스트로 가기
    @GetMapping("shopping/shopping")
    public void shopProducts() {

    }

    //상품 관리 페이지로 가기리스트)
    @GetMapping("shopping/productlist")
    public void manProducts() {
    }

    //상품 등록 페이지로 가기(insert)
    @GetMapping("shopping/uploadproduct")
    public void uploadProductsP() {
    }

    //상품 등록(image 파일 추가)
//    @PostMapping("shopping/uploadproduct")
//    public String uploadProduct(Products products){
//     productService.insert(products.getCategory(),products.getFilename()
//     ,products.getProductcontent(),products.getPrice(),products.getQuantity(),products.getEtc(),
//             products.getUuid(),products.getFilename(),products.getRegDate());
//
//        return "/shopping/productlist";
//    }
}
