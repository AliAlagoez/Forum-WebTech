package de.htwberlin.webtech.demo;

import de.htwberlin.webtech.demo.web.persistence.PostEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PostEntityTest {

    @Test
    @DisplayName("Test, ob der Standardkonstruktor das aktuelle Datum und Zeit setzt")
    public void testDefaultConstructor() {
        PostEntity post = new PostEntity();

        assertNotNull(post.getCreatedAt(), "CreatedAt sollte nicht null sein");
    }

    @Test
    @DisplayName("Test, ob der benutzerdefinierte Konstruktor die richtigen Werte setzt")
    public void testParameterizedConstructor() {
        LocalDateTime now = LocalDateTime.now();
        PostEntity post = new PostEntity("Title", "Content", "Author", now);

        assertEquals("Title", post.getTitle(), "Title sollte gesetzt sein");
        assertEquals("Content", post.getContent(), "Content sollte gesetzt sein");
        assertEquals("Author", post.getAuthor(), "Author sollte gesetzt sein");
        assertEquals(now, post.getCreatedAt(), "CreatedAt sollte gesetzt sein");
    }

    @Test
    @DisplayName("Test der Getter- und Setter-Methoden")
    public void testGettersAndSetters() {
        PostEntity post = new PostEntity();

        post.setId(1L);
        post.setTitle("New Title");
        post.setContent("New Content");
        post.setAuthor("New Author");
        LocalDateTime now = LocalDateTime.now();
        post.setCreatedAt(now);

        assertEquals(1L, post.getId(), "ID sollte gesetzt sein");
        assertEquals("New Title", post.getTitle(), "Title sollte gesetzt sein");
        assertEquals("New Content", post.getContent(), "Content sollte gesetzt sein");
        assertEquals("New Author", post.getAuthor(), "Author sollte gesetzt sein");
        assertEquals(now, post.getCreatedAt(), "CreatedAt sollte gesetzt sein");
    }
}
