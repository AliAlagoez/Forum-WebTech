package de.htwberlin.webtech.demo.web.api;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Genre") // Name der Datenbanktabelleasd
public class Genre {


    @Column(name = "name", nullable = false) // Spalte für den Namen des Genres
    private String name; // Name des Genres

    @Column(name = "desing") // Spalte für das Farbschema oder Design-Aspekte
    private String design; // Farbschema oder Design für das Genre

    // Beziehung zwischen Genre und Post
    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL) // Ein Genre kann mehrere Posts haben
    private List<Post> posts; // Liste der Posts, die zu diesem Genre gehören

    public Genre() {
        // Standard-Konstruktor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String colorScheme) {
        this.design = colorScheme;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}

