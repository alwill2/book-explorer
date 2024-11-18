package org.book.explorer.web.api.author;

public record AuthorCreateRequest(
    String name
) {

    public static final String MEDIA_TYPE = "application/x.example.library.author.create+json;version=1";

}
