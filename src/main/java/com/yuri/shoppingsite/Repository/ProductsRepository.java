package com.yuri.shoppingsite.Repository;

import com.yuri.shoppingsite.domain.shop.Products;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Products,Long> {

    @EntityGraph(attributePaths = {"imageSet"})
    @Query("select b from Products b where b.bno = :bno")
    Optional<Products> findByIdWithImages(Long bno);


}
