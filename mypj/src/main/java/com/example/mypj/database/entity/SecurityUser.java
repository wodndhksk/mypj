package com.example.mypj.database.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
@Slf4j
@Getter @Setter
public class SecurityUser extends User {

    public SecurityUser(Account account){
        super(account.getEmail(), account.getPassword(), AuthorityUtils.createAuthorityList());

    }
}
