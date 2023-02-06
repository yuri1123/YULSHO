package com.yuri.shoppingsite.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter
@Setter
public class MemberDTO {

    private int uno;
    private String userId;
    private String userPassword;
    private String userName;
    @DateTimeFormat(pattern = "yyyy-MM-DD")
    private Date userBirth;
    private String userPhone;
    private String userEmail;

    @Override
    public String toString() {
        return "MemberDTO{" +
                "uno=" + uno +
                ", userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userBirth=" + userBirth +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}




