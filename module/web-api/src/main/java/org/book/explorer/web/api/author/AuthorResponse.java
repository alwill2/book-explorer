package org.book.explorer.web.api.author;

import lombok.Builder;
import org.book.explorer.domain.Author;

@Builder
public record AuthorResponse(
    String name
) {

    public static final String MEDIA_TYPE = "application/x.example.library.author+json;version=1";

    public static AuthorResponse from(Author actor) {
        return AuthorResponse.builder()
            .name(actor.getName())
            .build();
    }
}
