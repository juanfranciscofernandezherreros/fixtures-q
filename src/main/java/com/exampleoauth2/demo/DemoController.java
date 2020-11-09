package com.exampleoauth2.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
    private String home() {
      return "Welcome home!";
    }
}
