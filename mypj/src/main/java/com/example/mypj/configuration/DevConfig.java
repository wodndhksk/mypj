package com.example.mypj.configuration;

import com.example.mypj.database.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

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
//    @PostConstruct
//    public void createTestUser(){
//        Account account = Account.builder()
//                .email("test@test.com")
//                .password(passwordEncoder.encode("1234"))
//                .type(AccountType.USER)
//                .build();
//        //동일한 테스트 이메일 계정이 존재할 시
//        String str = accountRepository.findByEmail(account.getEmail());
//        if("Optional.empty".equals(str))
//            accountRepository.save(account);
//        log.info("TestUser(" + account.getEmail() + ") has been created.");
//    }
}
