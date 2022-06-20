package com.example.mypj.test.restApi;

import com.example.mypj.auth.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/test")
public class TestContorller {
    private final AccountService accountService;

    @PostMapping("/test1")
    public ResponseEntity loginTest(@RequestBody LoginReq loginReq){
        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.LOGIN_SUCCESS, loginReq), HttpStatus.OK);
    }

    @PostMapping("test2")
    public ResponseEntity loginTest2(@RequestBody LoginReq loginReq){

        loginReq.setFriendId(accountService.randomCode());

        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.LOGIN_SUCCESS, loginReq), HttpStatus.OK);
    }
}
