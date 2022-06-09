package com.example.mypj.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthPageController {
    private final AccountService accountService;

    @GetMapping(value="/signin")
    public String signIn(Model model) {

        return "/auth/signin";
    }

    @RequestMapping(value="/signup")
    public String signUp(Model model) {

        return "/auth/signup";
    }
}
