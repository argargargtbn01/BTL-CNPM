package assignment.book.controller;

import assignment.book.dto.response.BookResponseDto;
import assignment.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
