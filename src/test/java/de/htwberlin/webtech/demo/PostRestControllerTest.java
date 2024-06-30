package de.htwberlin.webtech.demo;

import de.htwberlin.webtech.demo.web.PostRestController;
import de.htwberlin.webtech.demo.web.persistence.PostEntity;
import de.htwberlin.webtech.demo.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PostRestControllerTest {

    @Mock
    private PostRepository mockRepository;

    private PostRestController controller;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        controller = new PostRestController(mockRepository);
    }

    @Test
    @DisplayName("Test, ob fetchPosts() alle Posts korrekt zurückgibt")
    public void testFetchPosts() {
        PostEntity post1 = new PostEntity("JO", "echt nicht", "Mois", LocalDateTime.now());
        PostEntity post2 = new PostEntity("dbg","ggg","Boss",LocalDateTime.now());
        List<PostEntity> mockPosts = Arrays.asList(post1, post2);

        when(mockRepository.findAll()).thenReturn(mockPosts);

        ResponseEntity<List<PostEntity>> response = controller.fetchPosts();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size()); // Assuming there are two posts in the mock data
    }
    @Test
    @DisplayName("Test, ob postBruh() einen neuen Post erfolgreich speichert")
    public void testPostBruh() {
        PostEntity newPost = new PostEntity("Blaba", "Mhm Okö", "Haha", LocalDateTime.now());
        when(mockRepository.save(any(PostEntity.class))).thenReturn(newPost);

        ResponseEntity<PostEntity> response = controller.postBruh(newPost);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(newPost, response.getBody());
    }

    @Test
    @DisplayName("Test, ob deletePost() einen Post erfolgreich löscht")
    public void testDeletePost() {
        Long postId = 1L;
        when(mockRepository.existsById(postId)).thenReturn(true);

        ResponseEntity<Void> response = controller.deletePost(postId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @DisplayName("Test, ob updatePost() einen vorhandenen Post erfolgreich aktualisiert")
    public void testUpdatePost() {
        Long postId = 1L;
        PostEntity existingPost = new PostEntity("Real", "auf trocken", "Apored", LocalDateTime.now());
        PostEntity updatedPost = new PostEntity( "update", "jo", "Bernd", LocalDateTime.now());

        when(mockRepository.findById(postId)).thenReturn(Optional.of(existingPost));
        when(mockRepository.save(any(PostEntity.class))).thenReturn(updatedPost);

        ResponseEntity<PostEntity> response = controller.updatePost(postId, updatedPost);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedPost, response.getBody());
    }
}
