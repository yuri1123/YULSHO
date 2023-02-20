package com.yuri.shoppingsite.domain.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberFormDto {

    private String name;
    private String email;
    private String password;
    private String address;
    private String nickname;
    private String birth;
    private String phone;

}
