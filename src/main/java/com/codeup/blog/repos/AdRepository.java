package com.codeup.blog.repos;

import com.codeup.blog.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {
    Ad findByDescription(String desc);
    List<Ad> findAllByTitleIsLike(String term);
}
