package com.wilddiary.services.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Demo service to greet an optional input name of a person with an optional input delay. */
@SpringBootApplication
public class HelloService {

  /**
   * Application's entry point.
   *
   * @param args input arguments to the application
   */
  public static void main(String[] args) {
    SpringApplication.run(HelloService.class, args);
  }
}
