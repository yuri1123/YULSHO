package com.yuri.shoppingsite.service;

import com.yuri.shoppingsite.Repository.ProductsRepository;
import com.yuri.shoppingsite.domain.shop.Products;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductsRepository productsRepository;


    public void insert(String category,
                           String productname,
                           String productcontent,
                           Long price,
                           Integer quantity,
                           String etc,
                           String uuid,
                           String filename,
                           LocalDateTime regDate){
        Products p = new Products();
        p.setCategory(category);
        p.setProductname(productname);
        p.setProductcontent(productcontent);
        p.setPrice(price);
        p.setQuantity(quantity);
        p.setEtc(etc);
        p.setUuid(uuid);
        p.setFilename(filename);
        p.setRegDate(LocalDateTime.now());
        this.productsRepository.save(p);
    }

}
