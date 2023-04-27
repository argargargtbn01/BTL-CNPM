package assignment.book.service.book;

import assignment.book.dto.request.BookRequestDto;
import assignment.book.dto.response.BookResponseDto;
import assignment.book.entity.Book;
import assignment.book.exception.NotFoundException;
import assignment.book.mapper.BookMapper;
import assignment.book.repository.BookRepository;
import assignment.book.service.uploadfile.UploadFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    private final UploadFileService uploadFileService;
    @Override
    public List<BookResponseDto> getAllBook() {
        List<Book> books = bookRepository.getAllBook();
        List<BookResponseDto> bookResponseDtos = new ArrayList<>();
        for (Book book: books){
            BookResponseDto bookResponseDto = bookMapper.toBookResponseDto(book);
            bookResponseDtos.add(bookResponseDto);
        }
        return bookResponseDtos;
    }

    @Override
    public BookResponseDto getBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        Book book = optionalBook.orElseThrow(() -> new NotFoundException("book with id = " + id +  " not found"));
        BookResponseDto bookResponseDto = bookMapper.toBookResponseDto(book);
        return bookResponseDto;
    }

    @Override
    public List<BookResponseDto> getBookByOwner_id(Long owner_id) {
        List<Book> books = bookRepository.getBookByOwner_id(owner_id);
        List<BookResponseDto> bookResponseDtos = new ArrayList<>();
        for (Book book: books){
            BookResponseDto bookResponseDto = bookMapper.toBookResponseDto(book);
            bookResponseDtos.add(bookResponseDto);
        }
        return bookResponseDtos;
    }

    @Override
    public List<BookResponseDto> getBookByAuthor(String author) {
        List<Book> books = bookRepository.getBookByAuthor(author);
        List<BookResponseDto> bookResponseDtos = new ArrayList<>();
        for (Book book: books){
            BookResponseDto bookResponseDto = bookMapper.toBookResponseDto(book);
            bookResponseDtos.add(bookResponseDto);
        }
        return bookResponseDtos;
    }

    @Override
    public List<BookResponseDto> getBookByCategory(String category) {
        List<Book> books = bookRepository.getBookByCategory(category);
        List<BookResponseDto> bookResponseDtos = new ArrayList<>();
        for (Book book: books){
            BookResponseDto bookResponseDto = bookMapper.toBookResponseDto(book);
            bookResponseDtos.add(bookResponseDto);
        }
        return bookResponseDtos;
    }

    @Override
    public void createBook(BookRequestDto bookRequestDto, MultipartFile file) {
        Book book = bookMapper.toBook(bookRequestDto);
        String image_Link = uploadFileService.uploadFile(file);
        book.setImage_Link(image_Link);
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        Book book = optionalBook.orElseThrow(() -> new NotFoundException("book with id = " + id +  " not found"));
        bookRepository.deleteById(id);
    }

    @Override
    public void changeStatusToSold(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        Book book = optionalBook.orElseThrow(() -> new NotFoundException("book with id = " + id +  " not found"));
        book.setStatus(1);
        bookRepository.save(book);
    }
}
