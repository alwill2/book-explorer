package org.book.explorer.persistence.persistence.book;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer>, PagingAndSortingRepository<BookEntity, Integer> {

    Optional<BookEntity> findByTitle(String title);

}
