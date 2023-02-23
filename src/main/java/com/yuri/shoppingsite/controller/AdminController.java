package com.yuri.shoppingsite.controller;

import com.yuri.shoppingsite.domain.shop.Item;
import com.yuri.shoppingsite.domain.shop.ItemFormDto;
import com.yuri.shoppingsite.domain.shop.ItemSearchDto;
import com.yuri.shoppingsite.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final ItemService itemService;




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

    //상품 등록
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

    //상품 수정
    @PostMapping("admin/uploadproduct/{itemId}")
    public String itemUpdate(@Valid ItemFormDto itemFormDto,
                             BindingResult bindingResult,
                             @RequestParam("itemImgFile") List<MultipartFile> itemImgFileList,
                             Model model){
        if(bindingResult.hasErrors()){
            return "admin/uploadproduct";
        }
        if(itemImgFileList.get(0).isEmpty() && itemFormDto.getId() == null){
            model.addAttribute("errorMessage", "첫번째 상품 이미지는 필수 입력값입니다.");
            return "admin/uploadproduct";
        }
        try{
            itemService.updateItem(itemFormDto, itemImgFileList);
        } catch (Exception e){
            model.addAttribute("errorMessage", "상품 수정 중 에러가 발생하였습니다.");
            return "admin/uploadproduct";
        }
        return "redirect:/admin/productlist";
    }

    //상품관리 페이지 이동
    //value에 상품 관리 화면 진입시 URL에 페이지 번호가 없는 경우와 페이지 번호가 있는 경우 2가지를 매핑한다.
    @GetMapping(value = {"/admin/items","/admin/items/{page}"})
    public String itemManage(ItemSearchDto itemSearchDto,
                             @PathVariable("page") Optional<Integer> page,
                             Model model){
        //페이징을 위해 PageRequest.of 메소드를 통해 Pageable 객체를 생성한다.
        //첫번째 파라미터로는 조회할 때 페이지 번호, 두번째 파라미터로는 한번에 가지고 올 데이터 수를 넣음
        //URL 경로에 페이지 번호가 있으면 해당 페이지를 조회하도록 셋팅하고, 페이지 번호가 없으면 0페이지 조회
        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 3);
        //조회 조건과 페이징 정보를 파라미터로 넘겨서 Page<Item> 객체를 반환 받음
        Page<Item> items = itemService.getAdminItemPage(itemSearchDto, pageable);
        //조회한 상품 데이터 및 페이징 정보를 뷰에 전달
        model.addAttribute("items", items);
        //페이지 전환시 기존 검색 조건을 유지한 채 이동할 수 있도록 뷰에 다시 전달함
        model.addAttribute("itemSearchDto", itemSearchDto);
        //상품관리 메뉴 하단에 보여줄 최대 페이지 번호의 개수이다. 5로 설정하면 최대 5개의 이동할 페이지 번호만 보여준다.
        model.addAttribute("maxPage",3);
        return "admin/productlist";
    }






}
