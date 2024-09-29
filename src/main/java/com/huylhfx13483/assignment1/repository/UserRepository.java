package com.huylhfx13483.assignment1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huylhfx13483.assignment1.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
