package com.example.mypj.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.http.HttpRequest;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AccountService accountService;

    @RequestMapping(value="/signin")
    public String signIn(Model model, HttpRequest req) {

        return "auth/signin";
    }
    @PostMapping(value="/signin")
    public String afterSignIn(Model model, HttpRequest req) {

        return "auth/signin";
    }
    @RequestMapping(value="/signup")
    public String signUp(Model model) {

        return "auth/signup";
    }
}
