package assignment.book.service.savedbook;

import assignment.book.dto.request.SavedBookRequestDto;
import assignment.book.entity.Book;
import assignment.book.entity.SavedBook;
import assignment.book.entity.User;
import assignment.book.exception.NotFoundException;
import assignment.book.repository.BookRepository;
import assignment.book.repository.SavedBookRepository;
import assignment.book.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SavedBookServiceImpl implements SavedBookService {
    private final SavedBookRepository savedBookRepository;
    private final BookRepository bookRepository;
    private final ProfileRepository userRepository;

    @Override
    public List<Book> getSavedBook(Long user_id) {
        List<Book> book = savedBookRepository.getSavedBook(user_id);
        return book;
    }

    @Override
    public void saveBook(SavedBookRequestDto savedBookRequestDto) {
        Book book = bookRepository.findById(savedBookRequestDto.getBook_id()).orElseThrow(() -> new NotFoundException("book not found"));
        User user = userRepository.findById(savedBookRequestDto.getUser_id()).orElseThrow(() -> new NotFoundException("user not found"));
        SavedBook savedBook = new SavedBook();
        savedBook.setBook(book);
        savedBook.setUser(user);
        savedBookRepository.save(savedBook);
    }

}
