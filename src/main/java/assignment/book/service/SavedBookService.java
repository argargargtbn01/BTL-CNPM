package assignment.book.service;

import assignment.book.dto.request.SavedBookRequestDto;
import assignment.book.entity.Book;
import assignment.book.entity.SavedBook;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SavedBookService {

    List<Book> getSavedBook (Long user_id);
    void saveBook (SavedBookRequestDto savedBookRequestDto);
}
