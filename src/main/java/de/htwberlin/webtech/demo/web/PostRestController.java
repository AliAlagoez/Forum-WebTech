package de.htwberlin.webtech.demo.web;

import de.htwberlin.webtech.demo.web.persistence.PostEntity;
import de.htwberlin.webtech.demo.repository.PostRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Post")
@RestController
@CrossOrigin(origins = {"http://localhost:7777", "http://127.0.0.1:7777", "https://forum-webtech-frontend.onrender.com"})
public class PostRestController {

    private final PostRepository postRepository;

    public PostRestController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/post")
    public ResponseEntity<List<PostEntity>> fetchPosts() {
        return ResponseEntity.ok(postRepository.findAll());
    }

    @PostMapping("/post")
    public ResponseEntity<PostEntity> postBruh(@RequestBody PostEntity post) {
        return this.postRepository.save(post) != null ? ResponseEntity.ok(post) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
