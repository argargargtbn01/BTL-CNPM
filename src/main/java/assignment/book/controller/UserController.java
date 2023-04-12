package assignment.book.controller;

import assignment.book.dto.request.UserRequestDto;
import assignment.book.dto.response.UserResponseDto;
import assignment.book.service.AuthService;
import assignment.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUser(@PathVariable long id){
        UserResponseDto userResponseDto = userService.getUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }
}
