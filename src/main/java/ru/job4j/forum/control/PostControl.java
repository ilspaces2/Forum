package ru.job4j.forum.control;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostRepositoryService;

@Controller
public class PostControl {

    private PostRepositoryService postService;

    public PostControl(PostRepositoryService postService) {
        this.postService = postService;
    }

    @GetMapping("/toSave")
    public String toSave(Model model) {
        model.addAttribute("user", getUser());
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/index";
    }

    @GetMapping("/toUpdate")
    public String toUpdate(@RequestParam("idPost") int id, Model model) {
        model.addAttribute("user", getUser());
        model.addAttribute("post", postService.findByIdPost(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Post post) {
        postService.update(post);
        return "redirect:/index";
    }

    @GetMapping("/toPost")
    public String toPost(@RequestParam("idPost") int id, Model model) {
        model.addAttribute("user", getUser());
        model.addAttribute("post", postService.findByIdPost(id));
        return "post";
    }

    private Object getUser() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
