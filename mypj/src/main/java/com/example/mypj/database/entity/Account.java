package com.example.mypj.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@NoArgsConstructor
@Builder
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
    @NotBlank
    private String nickname;

    @Column
    private String email;

    @Column(length = 2050)
    private String thumbnailImageUrl;

    @Column(length = 2050)
    private String ProfileImageUrl;

}
