package com.example.mypj.auth;

import com.example.mypj.DTO.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AccountService accountService;

    @PostMapping(value="/login")
    public String afterSignIn(Model model, String signInEmail, String signInPassword) {

        System.out.printf("id : " + signInEmail);
        System.out.printf("id : " + signInPassword);

        return "/auth/signin";
    }
    @PostMapping(value="/signup")
    public String afterSignUp(AccountDto accountDto) {
        String a = accountDto.getInputEmail();
        accountService.createAccount(accountDto);

        return "redirect:/";
    }
}
