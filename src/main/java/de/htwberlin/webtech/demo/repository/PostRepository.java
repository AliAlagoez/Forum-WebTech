package de.htwberlin.webtech.demo.repository;

import de.htwberlin.webtech.demo.web.persistence.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
