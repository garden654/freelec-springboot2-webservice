package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user, HttpSession session) {
        model.addAttribute("posts", postsService.
findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
            session.setAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model, HttpSession session) {

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        String userName = (String) session.getAttribute("userName");
        if(dto.getUserName() == userName) {
            model.addAttribute("isUser", 1);
        } else {
            model.addAttribute("isUser", 0);
        }

        return "posts-update";
    }
}


