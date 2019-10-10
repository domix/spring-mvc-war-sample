package com.circulosiete.spring.sample.war.controller;

import com.circulosiete.spring.sample.war.service.RandomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

  private final RandomService randomService;

  public IndexController(RandomService randomService) {
    this.randomService = randomService;
  }

  @RequestMapping("/")
  public String showHomePage(Model m) {
    m.addAttribute("name", randomService.saludo() + ", este es un valor establecido en un controller de Spring MVC");
    return "index";
  }
}
