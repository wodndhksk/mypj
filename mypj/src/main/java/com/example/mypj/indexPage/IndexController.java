package com.example.mypj.indexPage;

import com.example.mypj.content.ContentsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class IndexController {
    private final ContentsService contentService;

    @GetMapping (value="/")
    public String index(Model model) {
        model.addAttribute("contentList", contentService.contentList());
        return "index";
    }
}
