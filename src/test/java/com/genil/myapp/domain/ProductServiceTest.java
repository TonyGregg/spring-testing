package com.genil.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

class ProductServiceTest {
  private ProductRepository productRepository;
  private ProductService productService;

  @BeforeEach
  void setUp() {
    productRepository = Mockito.mock(ProductRepository.class);
    productService = new ProductService(productRepository);
  }

  @Test
  void shouldReturnOnlyActiveProducts() {
    // Arrange
    Product p1 = new Product(1L, "p-name1", "p-desc", BigDecimal.ONE, false);
    Product p2 = new Product(2L, "p-name2", "p-desc", BigDecimal.TEN, true);
    BDDMockito.given(productRepository.findAll()).willReturn(List.of(p1, p2));
    // Act
    final List<Product> products = productService.getAllProducts();

    // Assert

    assertThat(products).hasSize(1);
    assertThat(products.get(0).getId()).isEqualTo(1L);

  }
}
