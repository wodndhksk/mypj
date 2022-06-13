package com.example.mypj.DTO;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ContentsDto {

    private String inputTitle;

    private String inputDescription;

    private String inputImageUrl;
}
