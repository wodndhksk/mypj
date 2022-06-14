package com.example.mypj.configuration.user;

import com.example.mypj.database.entity.Account;
import com.example.mypj.database.repository.AccountRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserPrincipalDetailService implements UserDetailsService {

    private AccountRepository accountRepository;

    public UserPrincipalDetailService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = this.accountRepository.findByEmail(email);
        if (account == null)
            throw new UsernameNotFoundException(email);
        UserPrincipal userPrincipal = new UserPrincipal(account);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(account.getRoles())); //exception 발생
        return userPrincipal;
    }
}
