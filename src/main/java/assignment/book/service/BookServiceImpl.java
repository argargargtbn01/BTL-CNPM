package assignment.book.service;

import assignment.book.entity.Book;
import assignment.book.mapper.BookMapper;
import assignment.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;

    private final BookMapper bookMapper;
    @Override
    public List<Book> getAllBook() {
        List<Book> books = new ArrayList<>();
        return null;
    }
}
