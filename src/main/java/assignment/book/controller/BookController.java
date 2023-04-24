package assignment.book.controller;

import assignment.book.dto.request.BookRequestDto;
import assignment.book.dto.response.BookResponseDto;
import assignment.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/")
    public ResponseEntity<?> getAllBook(){
        List<BookResponseDto> bookResponseDtos =bookService.getAllBook();
        return ResponseEntity.status(HttpStatus.OK).body(bookResponseDtos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getBook(@PathVariable Long id){
        BookResponseDto bookResponseDto =bookService.getBook(id);
        return ResponseEntity.status(HttpStatus.OK).body(bookResponseDto);
    }

    @GetMapping(value = "/owner/{owner_id}")
    public ResponseEntity<?> getBookByOwner_id(@PathVariable Long owner_id){
        List<BookResponseDto> bookResponseDtos =bookService.getBookByOwner_id(owner_id);
        return ResponseEntity.status(HttpStatus.OK).body(bookResponseDtos);
    }

    @GetMapping(value = "/author/{author}")
    public ResponseEntity<?> getBookByAuthor(@PathVariable String author){
        List<BookResponseDto> bookResponseDtos =bookService.getBookByAuthor(author);
        return ResponseEntity.status(HttpStatus.OK).body(bookResponseDtos);
    }

    @GetMapping(value = "/category/{category}")
    public ResponseEntity<?> getBookByCategory(@PathVariable String category){
        List<BookResponseDto> bookResponseDtos =bookService.getBookByCategory(category);
        return ResponseEntity.status(HttpStatus.OK).body(bookResponseDtos);
    }

    @PostMapping(value ="/")
    public ResponseEntity<?> createBook(@RequestParam MultipartFile file, @ModelAttribute BookRequestDto bookRequestDto){
        bookService.createBook(bookRequestDto,file);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
