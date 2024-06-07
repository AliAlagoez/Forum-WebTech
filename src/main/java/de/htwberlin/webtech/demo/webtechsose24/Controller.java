package de.htwberlin.webtech.demo.webtechsose24;


import de.htwberlin.webtech.demo.web.api.Post;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@CrossOrigin(origins = {"https://forum-webtech-frontend.onrender.com", "http://localhost:7777", "http://localhost:8080"})
public class Controller {

    @GetMapping("/post")
    public List<Post> index() {
        //test
        Post entry = new Post(3, "Test", "Test", "Test25", null);

        return List.of(entry);
    }

}
