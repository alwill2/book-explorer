package org.book.explorer.persistence;

import org.book.explorer.domain.Author;

public interface AuthorAdapter {

    Author create(String name);
    
}
