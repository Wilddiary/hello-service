package com.wilddiary.services.hello.controller;

import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** Rest controller for the Hello service. */
@RestController
public class HelloController {

  /**
   * GET method implementation for the resource.
   *
   * @param name Optional input name of a person.
   * @param millis Optional wait in milliseconds before greeting.
   * @return a message to greet the world or the input person.
   */
  @GetMapping("/hello")
  public String hello(
      @RequestParam("name") Optional<String> name, @RequestParam("delay") Optional<Long> millis) {
    if (name.isEmpty()) {
      name = Optional.of("World");
    }

    if (millis.isEmpty() || millis.get() < 0 || millis.get() > 5000) {
      millis = Optional.of(0L);
    }

    try {
      Thread.sleep(millis.get());
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    return "Hello, " + name.get() + "!";
  }
}
