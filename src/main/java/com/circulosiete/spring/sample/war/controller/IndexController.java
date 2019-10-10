package com.circulosiete.spring.sample.war.controller;

import com.circulosiete.spring.sample.war.service.RandomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static java.lang.String.format;

@Controller
public class IndexController {

  private final RandomService randomService;

  public IndexController(RandomService randomService) {
    this.randomService = randomService;
  }

  @RequestMapping("/")
  public String showHomePage(Model m) {
    String name = format("%s, este es un valor establecido en un controller de Spring MVC", randomService.saludo());
    m.addAttribute("name", name);
    return "index";
  }
}
