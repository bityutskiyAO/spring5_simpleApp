package guru.springframework.spring5WebApp.repositories;

import guru.springframework.spring5WebApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
