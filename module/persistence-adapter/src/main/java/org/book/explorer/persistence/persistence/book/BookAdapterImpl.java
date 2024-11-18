package org.book.explorer.persistence.persistence.book;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.book.explorer.domain.Book;
import org.book.explorer.persistence.BookAdapter;
import org.book.explorer.persistence.persistence.author.AuthorEntity;
import org.book.explorer.persistence.persistence.author.AuthorRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Log4j2
@Component
public class BookAdapterImpl implements BookAdapter {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public Book create(String author, Book book) {
        final AuthorEntity authorEntity = authorRepository.findByName(author).orElseThrow();

        final BookEntity bookEntity = BookEntity.from(book);
        bookEntity.getAuthor().add(authorEntity);

        log.info("create: {}", bookEntity);
        return bookRepository.save(bookEntity).toDomain();
    }

    public List<Book> getPage(int page, int size) {
        return bookRepository.findAll(PageRequest.of(page, size)).stream()
            .map(BookEntity::toDomain)
            .toList();
    }
}
