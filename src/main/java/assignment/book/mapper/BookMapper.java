package assignment.book.mapper;

import assignment.book.dto.request.BookRequestDto;
import assignment.book.dto.response.BookResponseDto;
import assignment.book.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public BookResponseDto toBookResponseDto (Book book){
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setId(book.getId());
        bookResponseDto.setOwner_id(book.getOwner_id());
        bookResponseDto.setISBN(book.getISBN());
        bookResponseDto.setImage_Link(book.getImage_Link());
        bookResponseDto.setAuthor(book.getAuthor());
        bookResponseDto.setDescription(book.getDescription());
        bookResponseDto.setPrice(book.getPrice());
        bookResponseDto.setCategory(book.getCategory());
        bookResponseDto.setStatus(book.getStatus());
        return bookResponseDto;
    }

    public Book toBook (BookRequestDto bookRequestDto){
        Book book = new Book();
        book.setOwner_id(bookRequestDto.getOwner_id());
        book.setISBN(bookRequestDto.getISBN());
        book.setAuthor(bookRequestDto.getAuthor());
        book.setDescription(bookRequestDto.getDescription());
        book.setPrice(bookRequestDto.getPrice());
        book.setCategory(bookRequestDto.getCategory());
        book.setStatus(0);
        return book;
    }
}
