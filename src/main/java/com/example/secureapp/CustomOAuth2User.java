package com.example.secureapp;

import java.util.Collection;
import java.util.Map;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class CustomOAuth2User implements OAuth2User {

  private String oAuth2ClientName;
  private OAuth2User oAuth2User;

  public CustomOAuth2User(OAuth2User oAuth2User, String oAuth2ClientName) {
    this.oAuth2User = oAuth2User;
    this.oAuth2ClientName = oAuth2ClientName;
  }

  @Override
  public Map<String, Object> getAttributes() {
    return oAuth2User.getAttributes();
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return oAuth2User.getAuthorities();
  }

  @Override
  public String getName() {
    return oAuth2User.getAttribute("name");
  }

  public String getEmail() {
    return oAuth2User.<String>getAttribute("email");
  }

  public String getOAuth2ClientName() {
    return this.oAuth2ClientName;
  }
}
