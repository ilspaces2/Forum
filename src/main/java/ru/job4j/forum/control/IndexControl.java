package ru.job4j.forum.control;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.forum.service.PostRepositoryService;

@Controller
public class IndexControl {

    private PostRepositoryService postService;

    public IndexControl(PostRepositoryService postService) {
        this.postService = postService;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("posts", postService.findAll());
        return "index";
    }
}
