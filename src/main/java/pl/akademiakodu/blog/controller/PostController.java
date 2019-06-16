package pl.akademiakodu.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akademiakodu.blog.model.Post;
import pl.akademiakodu.blog.repository.PostRepository;

@RequestMapping("/posts")
@Controller
public class PostController {


    private PostRepository postRepository;

    public PostController(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @GetMapping("/add")
    public String addPost(ModelMap modelMap){
        modelMap.put("post",new Post());
        return "posts/add";
    }

    @PostMapping("")
    public String createPost(@ModelAttribute Post post, ModelMap modelMap){
        postRepository.save(post);
        modelMap.put("post",post);
        return "posts/show";
    }

}
