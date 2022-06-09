package com.example.mypj.auth;

import com.example.mypj.database.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private AccountRepository accountRepository;

    public void login(String email, String password){
        accountRepository.findByEmailAndPassword(email, password);
    }
}
