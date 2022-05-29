package com.example.connecttomysql.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.YearMonth;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Setter(AccessLevel.NONE)
  private Long id;

  @NotBlank
  @Size(max = 1024, min = 1)
  private String title;

  @Positive private Integer pageNumber;

  @PastOrPresent private YearMonth publishedTime;

  @ManyToMany(mappedBy = "books")
  private Set<Author> authors;

  @Builder
  public Book(String title, Integer pageNumber, YearMonth publishedTime) {
    this.title = title;
    this.pageNumber = pageNumber;
    this.publishedTime = publishedTime;
  }

  public void addBookAuthor(Author author) {
    Objects.requireNonNull(author);
    if (Objects.isNull(authors)) {
      authors = new HashSet<>();
    }
    //authors.add(author);
  }
}
