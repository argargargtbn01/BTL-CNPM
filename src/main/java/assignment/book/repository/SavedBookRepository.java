package assignment.book.repository;

import assignment.book.entity.Book;
import assignment.book.entity.SavedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SavedBookRepository extends JpaRepository<SavedBook,Long> {
    @Query("SELECT s.book FROM SavedBook s JOIN s.book b WHERE s.user.id = :user_id AND b.status = 0 ")
    List<Book> getSavedBook (Long user_id);
}
