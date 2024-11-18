package org.book.explorer.web.api.author;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.Validate;
import org.book.explorer.AuthorService;
import org.book.explorer.domain.Author;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorApi {

    private final AuthorService authorService;

    @PostMapping(
        consumes = {AuthorCreateRequest.MEDIA_TYPE, MediaType.APPLICATION_JSON_VALUE},
        produces = {AuthorResponse.MEDIA_TYPE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<AuthorResponse> createBook(@RequestBody AuthorCreateRequest author) {
        Validate.notNull(author);

        final Author createdAuthor = authorService.create(author.name());

        return ResponseEntity.ok(AuthorResponse.from(createdAuthor));
    }

}
