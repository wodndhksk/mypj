package com.example.mypj.content;

import com.example.mypj.DTO.ContentsDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@AllArgsConstructor
@RequestMapping("/contents")
public class ContentsController {

    private final ContentsService contentsService;

    @GetMapping("/upload")
    public String upload(HttpServletRequest req, HttpServletResponse res){

        return "/contents/upload";
    }
    @PostMapping("/upload")
    public String uploadContentsData(ContentsDto contentsDto){
        String a = contentsDto.getInputTitle();
        String b = contentsDto.getInputDescription();
        String c = contentsDto.getInputImageUrl();

        contentsService.saveContents(contentsDto);

        return "/contents/upload";
    }
    @GetMapping("/modify")
    public String modify(HttpServletRequest req, HttpServletResponse res){

        return "/contents/modify";
    }
}
