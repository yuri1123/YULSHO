package com.yuri.shoppingsite.service;

import com.yuri.shoppingsite.Repository.CartItemRepository;
import com.yuri.shoppingsite.Repository.CartRepository;
import com.yuri.shoppingsite.Repository.ItemRepository;
import com.yuri.shoppingsite.Repository.MemberRepository;
import com.yuri.shoppingsite.domain.shop.Cart;
import com.yuri.shoppingsite.domain.shop.CartItem;
import com.yuri.shoppingsite.domain.shop.CartItemDto;
import com.yuri.shoppingsite.domain.shop.Item;
import com.yuri.shoppingsite.domain.user.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CartService {

    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    public Long addCart(CartItemDto cartItemDto, String name){
        //장바구니에 담을 상품 엔티티를 조회한다.
        Item item = itemRepository.findById(cartItemDto.getItemId())
                .orElseThrow(EntityNotFoundException::new);
        //현재 로그인한 회원 엔티티를 조회한다.
        Member member = memberRepository.findByName(name);
        //현재 로그인한 회원의 장바구니 엔티티를 조회한다.
        Cart cart = cartRepository.findByMemberId(member.getId());
        //상품을 처음으로 장바구니에 담을 경우 해당 회원의 장바구니 엔티티를 생성한다.
        if(cart == null){
            cart = Cart.createCart(member);
            cartRepository.save(cart);

        }
        //현재 상품이 장바구니에 이 미들어가 있는지 조회한다.
        CartItem savedCartItem =
                cartItemRepository.findByCartIdAndItemId(cart.getId(), item.getId());
        //장바구니에 이미 있던 상품일 경우 기존 수량에 현재 장바구니에 담을 수량 만큼 더해준다.
        if(savedCartItem != null){
            savedCartItem.addCount(cartItemDto.getCount());
            return savedCartItem.getId();
        } else {
            //장바구니 엔티티, 상품 엔티티, 장바구니에 담을 수량을 이용하여 CartItem 엔티티 생성
            CartItem cartItem =
                    CartItem.createCartItem(cart, item, cartItemDto.getCount());
            //장바구니에 들어갈 상품을 저장한다.
            cartItemRepository.save(cartItem);
            return cartItem.getId();
        }
    }
}
