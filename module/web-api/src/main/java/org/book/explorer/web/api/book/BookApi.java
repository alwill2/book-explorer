package org.book.explorer.web.api.book;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.Validate;
import org.book.explorer.BookService;
import org.book.explorer.domain.Book;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookApi {

    public static final int DEFAULT_REQUEST_PAGE_SIZE = 25;
    private final BookService bookService;

    @PostMapping(
        consumes = {BookCreateRequest.MEDIA_TYPE, MediaType.APPLICATION_JSON_VALUE},
        produces = {BookResponse.MEDIA_TYPE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<BookResponse> createBook(@RequestBody BookCreateRequest book) {
        Validate.notNull(book);

        final Book createdBook = bookService.createBook(book.author(), book.title());

        return ResponseEntity.ok(BookResponse.from(createdBook));
    }

    @GetMapping(produces = {BookResponse.MEDIA_TYPE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<BookResponse>> getAllPaged(@RequestParam(name = "page", defaultValue = "0") int page) {
        final List<BookResponse> pagedBooks = bookService.getPage(page, DEFAULT_REQUEST_PAGE_SIZE)
            .stream()
            .map(BookResponse::from)
            .toList();

        return ResponseEntity.ok(pagedBooks);
    }

}
