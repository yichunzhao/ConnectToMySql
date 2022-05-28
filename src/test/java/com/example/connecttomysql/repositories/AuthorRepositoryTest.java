package com.example.connecttomysql.repositories;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class AuthorRepositoryTest {

  @Autowired private BookRepository bookRepository;

  @Test
  void testGetAllBook() {
    var actual = bookRepository.findAll();
    assertThat(actual, Matchers.hasSize(0));
  }
}
