package com.wilddiary.services.hello;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Random;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class HelloServiceTests {

  @Autowired private MockMvc mockMvc;

  @Test
  void contextLoads() {}

  @Test
  public void shouldGreetTheWorld() throws Exception {
    this.mockMvc
        .perform(get("/hello"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Hello, World!")));
  }

  @Test
  public void shouldGreetTheWorldAfterTheGivenDelay() throws Exception {
    int delay = new Random().nextInt(5000);
    long start = System.currentTimeMillis();
    this.mockMvc
        .perform(get("/hello").param("delay", String.valueOf(delay)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Hello, World!")));
    long end = System.currentTimeMillis();
    assertThat(end - start).isGreaterThan(delay);
  }

  @Test
  public void shouldGreetThePerson() throws Exception {
    String name = UUID.randomUUID().toString();
    this.mockMvc
        .perform(get("/hello").param("name", name))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Hello, " + name + "!")));
  }

  @Test
  public void shouldGreetThePersonAfterTheGivenDelay() throws Exception {
    int delay = new Random().nextInt(5000);
    long start = System.currentTimeMillis();
    String name = UUID.randomUUID().toString();
    this.mockMvc
        .perform(get("/hello").param("name", name).param("delay", String.valueOf(delay)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Hello, " + name + "!")));
    long end = System.currentTimeMillis();
    assertThat(end - start).isGreaterThan(delay);
  }

  @Test
  public void shouldLimitTheGivenDelayToTheUpperBound() throws Exception {
    int delay = new Random().nextInt(5000, 10000);
    long start = System.currentTimeMillis();
    String name = UUID.randomUUID().toString();
    this.mockMvc
        .perform(get("/hello").param("name", name).param("delay", String.valueOf(delay)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Hello, " + name + "!")));
    long end = System.currentTimeMillis();
    assertThat(end - start).isLessThan(100);
  }
}
