package com.example.mypj.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String password;

    @Column
    private String phone;

    @Column
    private Long friendId;

    @Column
//    @NotBlank
    private String nickname;

    @Column
    private String email;

    @Column(length = 2050)
    private String thumbnailImageUrl;

    @Column(length = 2050)
    private String ProfileImageUrl;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Transactional
    public void encodePassword(PasswordEncoder passwordEncoder){
        password = passwordEncoder.encode(password);
    }
}
