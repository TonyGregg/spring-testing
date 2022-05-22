package com.genil.myapp.rest;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/** Created on Sun, 5/22/22 at 9:23 AM by Genil. */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWebMvc
public class IntegrationTest {
  @Autowired MockMvc mockMvc;

  @Test
  void getAllProducts() throws Exception {
    mockMvc
        .perform(MockMvcRequestBuilders.get("/api/products"))
        .andExpect(MockMvcResultMatchers.status().isOk());

  }
}
