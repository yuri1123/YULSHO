package com.yuri.shoppingsite.domain.user;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
public class MemberFormDto {

    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    private String name;
    @NotEmpty(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식으로 입력해주세요")
    private String email;
    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    @Length(max=16, message = "비밀번호는 16자리 이하로 입력해주세요")
    private String password;
    @NotEmpty(message = "주소는 필수 입력 값입니다.")
    private String address;
    private String nickname;
    private String birth;
    private String phone;

}
