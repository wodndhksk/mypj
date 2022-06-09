package com.example.mypj.database.entity;

import org.springframework.security.core.GrantedAuthority;

public enum AccountType implements GrantedAuthority {
    ADMIN, USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
