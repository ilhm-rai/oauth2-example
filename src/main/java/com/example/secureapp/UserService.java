package com.example.secureapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public void processOAuthPostLogin(String username) {
    User existUser = userRepository.findByUsername(username);

    if (existUser == null) {
      User newUser = new User();
      newUser.setUsername(username);
      newUser.setProvider(Provider.GOOGLE);
      newUser.setEnabled(true);

      userRepository.save(newUser);
    }
  }
}
