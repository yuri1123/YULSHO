package com.yuri.shoppingsite.controller;

import com.yuri.shoppingsite.domain.shop.CartItemDto;
import com.yuri.shoppingsite.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping(value = "/cart")
    public @ResponseBody ResponseEntity order(@RequestBody @Valid CartItemDto cartItemDto,
                                              BindingResult bindingResult,
                                              Principal principal){
        //장바구니에 담을 상품 정보를 받는 cartItemDto 객체에 데이터 바인딩 시 에러가 있는지 검사
        if(bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for(FieldError fieldError : fieldErrors){
                sb.append(fieldError.getDefaultMessage());
            }
            return new ResponseEntity<String>(sb.toString(),
                    HttpStatus.BAD_REQUEST);
        }
        //현재 로그인한 회원의 이메일 정보를 변수에 저장한다.
        String name = principal.getName();
        Long cartItemId;

        try {
            //화면으로부터 넘어온 장바구니에 담을 상품 정보와 현재 로그인한 회원의 이메일 정보를 이용하여
            //장바구니에 상품을 담는 로직 호출
            cartItemId = cartService.addCart(cartItemDto, name);
        } catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
        //결과 값으로 생성된 장바구니 상품 아이디와 요청이 성공하였다는 HTTP 응답 상태 코드 반환
        return new ResponseEntity<Long>(cartItemId, HttpStatus.OK);
    }


}
