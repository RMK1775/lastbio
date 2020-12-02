package com.codeup.blog.repos;

import com.codeup.blog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByBody(String body);
    List<Post> findAllByTitleIsLike(String term);
}
