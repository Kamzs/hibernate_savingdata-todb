package pl.akademiakodu.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.akademiakodu.blog.model.Comment;
import pl.akademiakodu.blog.model.Post;
import pl.akademiakodu.blog.repository.PostRepository;

@RequestMapping("/posts")
@Controller
public class PostController {


    private PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/add")
    public String addPost(ModelMap modelMap) {
        modelMap.put("post", new Post());
        return "posts/add";
    }

    @PostMapping("")
    public String createPost(@ModelAttribute Post post) {
        postRepository.save(post);
        return "redirect:/posts/"+post.getId();
    }

    // posts/1
    @GetMapping("/{id}")
    public String showPost(@PathVariable Integer id, ModelMap modelMap) {
        Post post = postRepository.findById(id).get();
        modelMap.put("post", post);
        Comment comment = new Comment();
        comment.setPost(post);
        modelMap.put("comment",comment);
        modelMap.put("comments",post.getComments());
        return "posts/show";
    }

}
