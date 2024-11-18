package org.book.explorer;

import lombok.RequiredArgsConstructor;
import org.book.explorer.domain.Author;
import org.book.explorer.persistence.AuthorAdapter;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthorService {

    private final AuthorAdapter authorAdapter;

    public Author create(String name) {
        return authorAdapter.create(name);
    }

}
