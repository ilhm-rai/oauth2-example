package com.example.secureapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

  User findByUsername(String username);

  @Modifying
  @Query("UPDATE User u SET u.provider = ?2 WHERE u.username = ?1")
  public void updateAuthenticationProvider(String username, Provider provider);
}
