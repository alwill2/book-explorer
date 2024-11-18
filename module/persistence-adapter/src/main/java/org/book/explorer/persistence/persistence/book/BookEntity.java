package org.book.explorer.persistence.persistence.book;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.book.explorer.domain.Book;
import org.book.explorer.persistence.persistence.author.AuthorEntity;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "author")
@Data
@Entity
public class BookEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    @Default
    @ManyToMany
    private List<AuthorEntity> author = new ArrayList<>();

    public static BookEntity from(Book book) {
        return BookEntity.builder()
            .id(book.getId())
            .title(book.getTitle())
            .build();
    }

    public Book toDomain() {
        return Book.builder()
            .id(id)
            .title(title)
            .build();
    }
}
