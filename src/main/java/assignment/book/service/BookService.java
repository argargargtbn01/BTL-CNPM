package assignment.book.service;

import assignment.book.dto.response.BookResponseDto;
import assignment.book.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {
    List<BookResponseDto> getAllBook ();
}
