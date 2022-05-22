package com.genil.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ProductRepositoryTest {
  @Autowired EntityManager entityManager;
  @Autowired ProductRepository productRepository;

  @Test
  void findAllActiveProducts() {
    entityManager.persist(new Product(null,"pname1","pdec1", BigDecimal.ZERO, false));
    entityManager.persist(new Product(null,"pname2","pdec2", BigDecimal.TEN, true));
    final List<Product> products = productRepository.findAllActiveProducts();
    assertThat(products).hasSize(1);
    assertThat(products.get(0).getPrice()).isEqualTo(BigDecimal.ZERO);
  }
}
