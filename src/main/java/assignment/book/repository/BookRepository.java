package assignment.book.repository;

import assignment.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface BookRepository extends JpaRepository<Book, Id> {
}
