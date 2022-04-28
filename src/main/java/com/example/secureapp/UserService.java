package com.example.secureapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public void processOAuthPostLogin(String username, String oAuth2ClientName) {
    User existUser = userRepository.findByUsername(username);

    Provider provider = Provider.valueOf(oAuth2ClientName.toUpperCase());

    if (existUser == null) {
      User newUser = new User();
      newUser.setUsername(username);
      newUser.setProvider(provider);
      newUser.setEnabled(true);
      userRepository.save(newUser);
    } else {
      updateAuthenticationProvider(username, oAuth2ClientName);
    }
  }

  public void updateAuthenticationProvider(String username, String oAuth2ClientName) {
    User existUser = userRepository.findByUsername(username);
    Provider provider = Provider.valueOf(oAuth2ClientName.toUpperCase());
    if (existUser.getProvider() != provider) {
      userRepository.updateAuthenticationProvider(username, provider);
    }
  }
}
