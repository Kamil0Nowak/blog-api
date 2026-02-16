package com.kamil0nowak.blogapi.repositories;

import com.kamil0nowak.blogapi.domain.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
}
