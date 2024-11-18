package org.book.explorer;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.book.explorer.domain.Book;
import org.book.explorer.persistence.BookAdapter;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookAdapter bookAdapter;

    public List<Book> getPage(int page, int size) {
        return bookAdapter.getPage(page, size);
    }

    public Book createBook(String author, String title) {

        final Book book = Book.builder()
            .title(title)
            .build();

        return bookAdapter.create(author, book);
    }
}
