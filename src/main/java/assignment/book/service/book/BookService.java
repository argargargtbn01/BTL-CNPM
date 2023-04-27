package assignment.book.service.book;

import assignment.book.dto.request.BookRequestDto;
import assignment.book.dto.response.BookResponseDto;
import assignment.book.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {
    List<BookResponseDto> getAllBook ();

    BookResponseDto getBook(Long id);

    List<BookResponseDto> getBookByOwner_id(Long owner_id);

    List<BookResponseDto> getBookByAuthor(String author);

    List<BookResponseDto> getBookByCategory(String category);

    void createBook (BookRequestDto bookRequestDto, MultipartFile file);

    void deleteBook (Long id);

    void changeStatusToSold (Long id);


}
