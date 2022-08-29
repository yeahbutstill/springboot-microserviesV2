package com.yeahbutstill.springbootv3.dao;

import com.yeahbutstill.springbootv3.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDao extends JpaRepository<Post, String> {
}
