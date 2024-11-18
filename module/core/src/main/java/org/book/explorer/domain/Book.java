package org.book.explorer.domain;

import java.io.Serializable;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Book implements Serializable {

    private Integer id;

    private String title;

    private String originalTitle;

    private String description;

    private String premiered;

    private List<Author> authors;

}
