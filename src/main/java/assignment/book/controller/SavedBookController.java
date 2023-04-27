package assignment.book.controller;

import assignment.book.dto.request.SavedBookRequestDto;
import assignment.book.entity.Book;
import assignment.book.entity.SavedBook;
import assignment.book.service.SavedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/savedbooks")
public class SavedBookController {
    @Autowired
    private SavedBookService savedBookService;

//    @PostMapping(value = "/")
//    public ResponseEntity<?> saveBook(@RequestPart Long user_id, @RequestPart Long book_id){
//        savedBookService.saveBook(user_id, book_id);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }

    @GetMapping(value="/{user_id}")
    public ResponseEntity<?> getSavedBook(@PathVariable Long user_id){
        List<Book> book = savedBookService.getSavedBook(user_id);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> saveBook(@RequestBody SavedBookRequestDto savedBookRequestDto){
        savedBookService.saveBook(savedBookRequestDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
