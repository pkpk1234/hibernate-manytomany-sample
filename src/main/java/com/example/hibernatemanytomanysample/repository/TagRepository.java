package com.example.hibernatemanytomanysample.repository;

import com.example.hibernatemanytomanysample.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by l00388716 on 2017/5/19.
 */
public interface TagRepository extends JpaRepository<Tag,Long> {
}
