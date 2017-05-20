package com.example.hibernatemanytomanysample.repository;

import com.example.hibernatemanytomanysample.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by l00388716 on 2017/5/19.
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}
