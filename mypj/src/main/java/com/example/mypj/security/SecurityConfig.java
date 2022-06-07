package com.example.mypj.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 정적인 파일에 대한 요청들
    private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
//            "/v2/api-docs",
//            "/v3/api-docs/**",
//            "/configuration/ui",
//            "/swagger-resources/**",
//            "/configuration/security",
//            "/swagger-ui.html",
//            "/webjars/**",
//            "/file/**",
//            "/image/**",
//            "/swagger/**",
//            "/swagger-ui/**",
    };
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                // login 없이 접근 허용 하는 url
                .antMatchers("/auth/**").permitAll()
                // '/admin'의 경우 ADMIN 권한이 있는 사용자만 접근이 가능
                .antMatchers("/admin").hasRole("ADMIN")
                // 그 외 모든 요청은 인증과정 필요
                .anyRequest().authenticated();

        http.csrf().disable().authorizeRequests();

        http.formLogin()
                .loginPage("/auth/login")
                .defaultSuccessUrl("/") //로그인 되면 이동될 default URL
                .permitAll();

    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        // 정적인 파일 요청에 대해 무시
        web.ignoring().antMatchers(AUTH_WHITELIST);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
