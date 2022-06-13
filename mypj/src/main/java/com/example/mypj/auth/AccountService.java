package com.example.mypj.auth;

import com.example.mypj.DTO.AccountDto;
import com.example.mypj.database.entity.Account;
import com.example.mypj.database.entity.AccountType;
import com.example.mypj.database.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public void login(String email, String password){
        accountRepository.findByEmailAndPassword(email, password);
    }

    public void createAccount(AccountDto accountDto){
        Account account = Account.builder()
                .email(accountDto.getInputEmail())
                .password(passwordEncoder.encode(accountDto.getInputPassword()))
                .phone(accountDto.getInputPhone())
//                .friendId()
                .type(AccountType.USER)
                .build();
        accountRepository.save(account);
    }
}
