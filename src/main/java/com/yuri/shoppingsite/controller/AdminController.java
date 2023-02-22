package com.yuri.shoppingsite.controller;

import com.yuri.shoppingsite.domain.shop.ItemFormDto;
import com.yuri.shoppingsite.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final ItemService itemService;


    //상품 관리 페이지로 가기리스트)
    @GetMapping("admin/productlist")
    public String manProducts() {
        return "/admin/productlist";
    }

    //상품 등록 페이지로 가기(insert)
    @GetMapping("admin/uploadproduct")
    public String itemForm(Model model) {
        model.addAttribute("itemFormDto", new ItemFormDto());
        return "admin/uploadproduct";
    }

    //상품 상세 페이지로 가기
    @GetMapping("admin/uploadproduct/{itemId}")
    public String itemDtl(@PathVariable("itemId") Long itemId, Model model){
        try {
            ItemFormDto itemFormDto = itemService.getItemDtl(itemId);
            model.addAttribute("itemFormDto",itemFormDto);
        } catch(EntityNotFoundException e){
            model.addAttribute("errorMessage","존재하지 않는 상품입니다.");
            model.addAttribute("itemFormDto", new ItemFormDto());
            return "admin/uploadproduct";
        }
        return "admin/uploadproduct";
    }

    @PostMapping("admin/uploadproduct")
    public String itemNew(@Valid ItemFormDto itemFormDto, BindingResult bindingResult,
                           Model model, @RequestParam("itemImgFile") List<MultipartFile> itemImgFileList){

        //상품등록시 필수 값이 없다면 다시 상품 등록 페이지로 전환
        if(bindingResult.hasErrors()){
            return "admin/uploadproduct";
        }
        //상품 등록시 첫번째 이미지가 없다면 에러메시지와 함께 상품 등록 페이지로 전환한다.
        //상품의 첫번째 이미지는 메인 페이지에서 보여줄 상품 이미지로 사용하기 위해 필수 값으로 지정한다.
        if(itemImgFileList.get(0).isEmpty() && itemFormDto.getId() == null){
            model.addAttribute("errorMessage", "첫번째 상품 이미지는 필수 입력값 입니다.");
            return "admin/uploadproduct";
        }

        try {
            //상품 저장 로직을 호출한다. 매개변수로 상품정보와 상품 이미지 정보를 담고있는 itemImgFileList 넘겨줌
            itemService.saveItem(itemFormDto, itemImgFileList);
        } catch (Exception e){
            model.addAttribute("errorMessage","상품 등록 중 에러가 발생하였습니다.");
            return "admin/uploadproduct";
        }
        //정상적으로 저장되면 메인페이지로 이동
        return "admin/productlist";
    }


}
