package com.yeahbutstill.springbootv3.dao;

import com.yeahbutstill.springbootv3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, String> {
}
