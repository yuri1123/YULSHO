package com.yuri.shoppingsite.domain;

// 모든 entity의 상위 클래스
// entity들의 생성시간, 수정시간을 자동으로 관리

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //상속 클래스들이 부모 클래스의 컬럼을 인식하도록 설정
@EntityListeners(AuditingEntityListener.class) //auditing 기능
public abstract class BaseTimeEntity {

@CreatedDate
    private LocalDateTime createDateTime;

@LastModifiedDate
    private LocalDateTime modifiedDateTime;

}
