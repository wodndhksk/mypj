package com.example.mypj.configuration;

import com.example.mypj.database.entity.Account;
import com.example.mypj.database.entity.AccountType;
import com.example.mypj.database.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@Profile("dev")
@Configuration
@RequiredArgsConstructor
@Slf4j
public class DevConfig {
    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;

    /**
     * 테스트 계정 생성
     */
    @PostConstruct
    public void createTestUser(){
        Account member = Account.builder()
                .email("test@test.com")
                .password(passwordEncoder.encode("1234"))
                .type(AccountType.USER)
                .build();
        //동일한 테스트 이메일 계정이 존재할 시
        String str = accountRepository.findByEmail(member.getEmail()).toString();
        if("Optional.empty".equals(str))
            accountRepository.save(member);
        log.info("TestUser(" + member.getEmail() + ") has been created.");
    }
}
