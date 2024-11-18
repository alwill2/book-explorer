package org.book.explorer.persistence.persistence.author;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.book.explorer.domain.Author;
import org.book.explorer.persistence.persistence.book.BookEntity;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "books")
@Entity
public class AuthorEntity {

    @Id
    @GeneratedValue
    @Column
    private Integer id;

    @Column(unique = true)
    private String name;

    @ManyToMany
    private List<BookEntity> books;

    public Author toDomain() {
        return Author.builder()
            .name(name)
            .build();
    }
}
