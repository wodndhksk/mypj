package com.example.mypj.content;

import com.example.mypj.DTO.ContentsDto;
import com.example.mypj.database.entity.Contents;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

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
        contentsService.saveContents(contentsDto);
        return "index";
    }
    @GetMapping("/modify")
    public String modify(Model model, @RequestParam Long id){
        Optional<Contents> result = contentsService.selectOneById(id);
        if(result.isPresent())
            model.addAttribute("content", result.get());
        else result.orElse(null);
        return "/contents/modify";
    }
    @PostMapping("/modify")
    public String modifyAndUpdate(ContentsDto contentsDto, Long idx){
        contentsService.updateContents(contentsDto, idx);
        return "index";
    }
}
