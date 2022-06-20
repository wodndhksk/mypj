package com.example.mypj.test.restApi;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginReq {
    private String name;
    private String password;
    private String nickname;
    private String friendId;
}
