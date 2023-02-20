package com.yuri.shoppingsite.controller;

import com.yuri.shoppingsite.domain.shop.ItemDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Controller
public class ShoppingController {



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

    @GetMapping("shopping/test")
    public void gotest(Model model){
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setItemNm("테스트상품1");
        itemDTO.setItemDetail("상품 상세 설명");
        itemDTO.setPrice(10000);
        itemDTO.setRegTime(LocalDateTime.now());

        model.addAttribute("itemDTO",itemDTO);

        List<ItemDTO> itemDTOList = new ArrayList<>();
        for(int i=1; i<10; i++){
            ItemDTO itemDTO1 = new ItemDTO();
            itemDTO1.setItemDetail("상품 상세 설명");
            itemDTO1.setItemNm("테스트상품"+i);
            itemDTO1.setPrice(1000*i);
            itemDTO1.setRegTime(LocalDateTime.now());

            itemDTOList.add(itemDTO1);
            model.addAttribute("itemDtoList",itemDTOList);
        }
    }

    @GetMapping("shopping/test2")
    public void test2(String param1, String param2, Model model) {
        model.addAttribute("param1",param1);
        model.addAttribute("param2",param2);
    }


}