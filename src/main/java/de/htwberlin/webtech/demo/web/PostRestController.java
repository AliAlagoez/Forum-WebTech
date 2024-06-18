package de.htwberlin.webtech.demo.web;

import de.htwberlin.webtech.demo.web.persistence.PostEntity;
import de.htwberlin.webtech.demo.repository.PostRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/Post")
@RestController //asd
@CrossOrigin(origins = {"http://localhost:7777", "http://127.0.0.1:7777", "https://forum-webtech-frontend.onrender.com"})
public class PostRestController {

    private final PostRepository postRepository;
    private List<PostEntity> posts;

    public PostRestController(PostRepository postRepository) {
        this.postRepository = postRepository;
        posts = new ArrayList<>();
    }

    @GetMapping("/post")
    public ResponseEntity<List<PostEntity>> fetchPosts() {
        return ResponseEntity.ok(postRepository.findAll());
    }

    @PostMapping("/post")
    public ResponseEntity<PostEntity> postBruh(@RequestBody PostEntity post) {
        PostEntity savedPost = postRepository.save(post);
        return ResponseEntity.ok(savedPost);
    }
}
