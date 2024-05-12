package de.htwberlin.webtech.demo.web;

import de.htwberlin.webtech.demo.web.api.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PostRestController {

    private List<Post> posts;

    public PostRestController(){
        posts = new ArrayList<>();
        posts.add(new Post(1,"Mein Titel", "Hier ist mein Post ich schreibe irgendwas nutzloses", "Bernd77", LocalDateTime.of(2024, 5, 11, 10, 30)));
        posts.add(new Post(2,"Änten frage", "können Änten tauchen und wen ja wie lange xD", "SnipeMaster", LocalDateTime.of(2024, 7, 21, 3, 55)));
    }

    @GetMapping(path = "/api/v1/posts")
    public ResponseEntity<List<Post>> fetchPosts(){
      return ResponseEntity.ok(posts);
    }
}
