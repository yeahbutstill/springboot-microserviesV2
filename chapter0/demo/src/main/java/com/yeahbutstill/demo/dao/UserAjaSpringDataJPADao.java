package com.yeahbutstill.demo.dao;

import com.yeahbutstill.demo.entity.UserAja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAjaSpringDataJPADao extends JpaRepository<UserAja, String> {

    List<UserAja> findByEmail(String email);

}
