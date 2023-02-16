package com.yuri.shoppingsite.domain.shop;

import lombok.Getter;
import lombok.NoArgsConstructor;

public class ProductsDTO {

    @Getter
    @NoArgsConstructor
    public static class Response{
        private Long id;
        private String title;
        private String contetns;



    }


}
