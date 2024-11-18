package org.book.explorer.persistence;

import java.util.List;
import org.book.explorer.domain.Book;

public interface BookAdapter {

    List<Book> getPage(int page, int size);

    Book create(String author, Book book);
}
