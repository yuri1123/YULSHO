package com.yuri.shoppingsite.domain.user;

import com.yuri.shoppingsite.constant.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name="member")
public class Member {

    @Id
    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email; //이메일로 구분되어야 하므로 동일한 값 못오도록 unique 속성 지정
    private String password;
    private String address;
    private String nickname;
    private String birth;
    private String phone;
    @Enumerated(EnumType.STRING) //자바의 이넘타입을 엔티티 속성으로 지정
    //enum을 사용할 때 기본적으로 순서 저장되는데, enum의 순서가 바뀔 경우 문제가 발생할 수
    //있기 때문에 "EnumType.STRING" 옵션을 사용해서 String으로 지정하기를 권장
    private Role role;
    //Member 엔티티를 생성하는 메소드. 회원생성 메소드를 엔티티에 넣으면
    // 코드 변경시 한군데만 수정하면 되는 이점이 있음
    public static Member createMember(MemberFormDto memberFormDto,
                                      PasswordEncoder passwordEncoder){
        Member member = new Member();
        member.setName(memberFormDto.getName());
        member.setEmail(memberFormDto.getEmail());
        member.setAddress(memberFormDto.getAddress());
        String password=passwordEncoder.encode(memberFormDto.getPassword());
        member.setPassword(password);
        member.setNickname(memberFormDto.getNickname());
        member.setBirth(memberFormDto.getBirth());
        member.setPhone(memberFormDto.getPhone());
        member.setRole(Role.USER);
        return member;
    }
}
