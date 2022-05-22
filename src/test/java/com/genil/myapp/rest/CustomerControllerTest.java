package com.genil.myapp.rest;

import static org.junit.jupiter.api.Assertions.*;

import com.genil.myapp.domain.ProductService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = ProductController.class)
class CustomerControllerTest {

  @Autowired MockMvc mockMvc;

  @MockBean
  private ProductService productService;

  @Test
  void getAllProducts() throws Exception {
    mockMvc
        .perform(MockMvcRequestBuilders.get("/api/products"))
        .andExpect(MockMvcResultMatchers.status().isOk());

    BDDMockito.given(productService.getAllProducts()).willReturn(List.of());

  }
}
