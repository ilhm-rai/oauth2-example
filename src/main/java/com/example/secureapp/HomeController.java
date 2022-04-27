package com.example.secureapp;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

  @RequestMapping("/")
  public String home() {
    return "home";
  }

  @RequestMapping("/login")
  public String loginPage() {
    return "login";
  }

  @RequestMapping("/logout-success")
  public String logoutPage() {
    return "logout-success";
  }

  @RequestMapping("/user")
  @ResponseBody
  public Principal user(Principal principal) {
    return principal;
  }
}
