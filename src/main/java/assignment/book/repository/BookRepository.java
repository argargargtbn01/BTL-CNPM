package assignment.book.repository;

import assignment.book.entity.Book;
import assignment.book.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.status = 0")
    List<Book> getAllBook();

    @Query("SELECT b FROM Book b WHERE b.owner_id = :owner_id")
    List<Book> getBookByOwner_id(Long owner_id);

    @Query("SELECT b FROM Book b WHERE b.author = :author")
    List<Book> getBookByAuthor(String author);

    @Query("SELECT b FROM Book b WHERE b.category = :category")
    List<Book> getBookByCategory(String category);


}
