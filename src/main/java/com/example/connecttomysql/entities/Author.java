package com.example.connecttomysql.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(indexes = @Index(columnList = "firstName,lastName"))
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Setter(AccessLevel.NONE)
  private Long id;

  @NotBlank
  @Size(max = 256, min = 1)
  private String firstName;

  @NotBlank
  @Size(max = 256, min = 1)
  private String lastName;

  @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
  @JoinTable(
      name = "book_author",
      joinColumns = @JoinColumn(name = "author_id"),
      inverseJoinColumns = @JoinColumn(name = "book_id"))
  @Setter(AccessLevel.NONE)
  private Set<Book> books;

  @Builder
  public Author(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public void addAuthorBook(Book book) {
    Objects.requireNonNull(book);
    if (Objects.isNull(books)) {
      books = new HashSet<>();
    }
    books.add(book);
    book.addBookAuthor(this);
  }
}
