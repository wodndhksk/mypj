package com.example.mypj.auth;

import com.example.mypj.DTO.AccountDto;
import com.example.mypj.database.entity.Account;
import com.example.mypj.database.entity.AccountType;
import com.example.mypj.database.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

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
//                .nickname()
//                .friendId()
                .type(AccountType.USER)
                .build();
        accountRepository.save(account);
    }


    /**
     * friendId(계정 코드 생성)
     * 같은 nickname 존재시 구분할 중복없는 절대코드 생성
     * 같은 nickname 없을 시 랜덤코드 발급
     * @param nickname
     * @return
     */
    //TODO: 랜덤 코드(friendId) 발급 테스트 진행 필요 !!
    public String creatFriedIdCode(String nickname){
        String code = "";
        Optional<Account> result = accountRepository.findByNickname(nickname);
        if(result.isPresent()){
            while(accountRepository.findByFriendId(code) == null)
                code = randomCode();
        }
        else code = randomCode();

        return code;
    }

    public String randomCode(){
        int code = 0;
        Random random = new Random();
        code = random.nextInt(10000);
        return Integer.toString(code);
    }
}
