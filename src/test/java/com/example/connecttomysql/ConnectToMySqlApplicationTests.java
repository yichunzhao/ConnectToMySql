package com.example.connecttomysql;

import com.example.connecttomysql.repositories.AuthorRepository;
import com.example.connecttomysql.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest
class ConnectToMySqlApplicationTests {
  @Autowired private AuthorRepository authorRepository;

  @Autowired private BookRepository bookRepository;
  @Test
  void contextLoads() {
    assertThat(authorRepository, is(notNullValue()));
    assertThat(bookRepository, is(notNullValue()));
  }
}
