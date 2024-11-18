package org.book.explorer.web.api.book;

public record BookCreateRequest(
    String title,
    String author
) {

    public static final String MEDIA_TYPE = "application/x.example.library.book.create+json;version=1";
}
