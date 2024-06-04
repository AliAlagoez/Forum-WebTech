package de.htwberlin.webtech.demo.webtechsose24;


import de.htwberlin.webtech.demo.web.api.Post;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@CrossOrigin(origins = {"https://forum-webtech-frontend.onrender.com"})
public class Controller {

    @GetMapping("/")
    public List<Post> index() {
        //test
        Post entry = new Post(3, "Test", "Test", "Test", null);

        return List.of(entry);
    }

}
