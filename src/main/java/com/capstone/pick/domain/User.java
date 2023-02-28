package com.capstone.pick.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id @Column(length = 50, name = "user_id")
    private String userId; // 유저 Id

    @Column(nullable = false)
    private String userPassword; // 유저 암호

    @Column(length = 100)
    private String email; // 이메일

    @Column(length = 100)
    private String nickname; // 닉네임

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(nullable = false, updatable = false)
    private LocalDateTime birthday; // 출생일시

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt; // 생성일시

    private String memo; // 메모

    /* TODO: 가입방식과 멤버십은 주요 기능이 완료된 후에
         멤버십과 소셜 로그인 기능을 구현한 후에 진행하도록 한다.
    private String provider; // 가입방식
    private String membership; // 멤버십
    */
    
}