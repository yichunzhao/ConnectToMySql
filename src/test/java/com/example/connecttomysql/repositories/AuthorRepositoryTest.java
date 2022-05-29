package com.example.connecttomysql.repositories;

import com.example.connecttomysql.entities.Author;
import com.example.connecttomysql.entities.Book;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.Month;
import java.time.YearMonth;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AuthorRepositoryTest {
  @Autowired private BookRepository bookRepository;

  @Autowired private AuthorRepository authorRepository;

  @Test
  void testGetAllBook() {
    var actual = bookRepository.findAll();
    assertThat(actual, Matchers.hasSize(0));
  }

  @Test
  void saveAuthor() {
    var author = Author.builder().firstName("Mike").lastName("Smith").build();
    var persisted = authorRepository.save(author);

    assertNotNull(persisted);
    assertNotNull(persisted.getId());
  }

  @Test
  void saveAuthorBook() {
    var book =
        Book.builder()
            .title("my book")
            .publishedTime(YearMonth.of(1998, Month.APRIL))
            .pageNumber(1000)
            .build();
    var author = Author.builder().firstName("Mike").lastName("Smith").build();
    author.addAuthorBook(book);

    var persisted = authorRepository.save(author);
    assertNotNull(persisted);
    assertNotNull(persisted.getId());

    var allPersistedBooks = bookRepository.findAll();
    assertThat(allPersistedBooks, Matchers.hasSize(1));
  }
}
