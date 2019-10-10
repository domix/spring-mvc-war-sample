package com.circulosiete.spring.sample.war.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

  @RequestMapping("/mvc")
  public String showHomePage(Model m) {
    m.addAttribute("name", "Este es un valor establecido en un controller de Spring MVC");
    return "index";
  }
}
