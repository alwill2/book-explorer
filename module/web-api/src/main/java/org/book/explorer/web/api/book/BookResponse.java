package org.book.explorer.web.api.book;

import lombok.Builder;
import lombok.Data;
import org.book.explorer.domain.Book;

@Data
@Builder
public class BookResponse {

    public static final String MEDIA_TYPE = "application/x.example.library.book+json;version=1";

    private Integer id;

    private String title;

    public static BookResponse from(Book book) {
        return BookResponse.builder()
            .id(book.getId())
            .title(book.getTitle())
            .build();
    }
}
