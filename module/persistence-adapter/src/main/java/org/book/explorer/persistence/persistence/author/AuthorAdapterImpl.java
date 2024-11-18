package org.book.explorer.persistence.persistence.author;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.book.explorer.domain.Author;
import org.book.explorer.persistence.AuthorAdapter;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Log4j2
@Component
public class AuthorAdapterImpl implements AuthorAdapter {

    private final AuthorRepository authorRepository;

    public Author create(String name) {
        final AuthorEntity authorEntity = AuthorEntity.builder()
            .name(name)
            .build();

        log.info("create: {}", authorEntity);
        return authorRepository.save(authorEntity).toDomain();
    }
}
