package com.yuri.shoppingsite.Repository;

import com.yuri.shoppingsite.domain.shop.MemberSearchDto;
import com.yuri.shoppingsite.domain.user.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberRepositoryCustom {

    Page<Member> getAdminMemberPage(MemberSearchDto memberSearchDto, Pageable pageable);

}
