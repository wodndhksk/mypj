package com.example.mypj.database.repository;

import com.example.mypj.database.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository  extends JpaRepository<Account, Long> {
    Account findByEmail(String email);
//    Optional<Account> findByEmail(String email);
    Account findByFriendId(String friendId);
    Optional<Account> findByNickname(String nickname);
    Optional<Account> findByEmailAndPassword(String email, String password);


}
