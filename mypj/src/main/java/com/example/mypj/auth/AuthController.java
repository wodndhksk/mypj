package com.example.mypj.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final AccountService accountService;

    @PostMapping(value="/login")
    public String afterSignIn(Model model, String signInEmail, String signInPassword) {

        System.out.printf("id : " + signInEmail);
        System.out.printf("id : " + signInPassword);

        return "/auth/signin";
    }
}
