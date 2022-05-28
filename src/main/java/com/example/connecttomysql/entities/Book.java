package com.example.connecttomysql.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    private Long id;

    private String title;
    private YearMonth publishedTime;

    @ManyToMany(mappedBy = "books")
    private Set<Author> authors = new HashSet<>();

    public void addBookAuthor(Author author){
        Objects.requireNonNull(author);
        authors.add(author);
    }
}
