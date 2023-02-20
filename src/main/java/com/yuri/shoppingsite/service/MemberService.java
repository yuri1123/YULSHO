package com.yuri.shoppingsite.service;

import com.yuri.shoppingsite.Repository.MemberRepository;
import com.yuri.shoppingsite.domain.user.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional //비즈니스 로직 담당 서비스 계층 클래스에 선언, 로직 처리시 에러가 발생하면
//변경된 데이터 로직을 수행하기 이전 상태로 콜백 시켜준다.
@RequiredArgsConstructor //final이나 @NonNull이 붙은 필드에 생성자 생성
public class MemberService {

    private final MemberRepository memberRepository;
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    //이미 가입된 회원은 IllegalStateException 예외 발생
    public void validateDuplicateMember(Member member){
        Member findMember = memberRepository.findByEmail(member.getEmail());
        if(findMember != null){
            throw new IllegalStateException("이미 가입된 회원입니다");
        }
    }

}

