package assignment.book.controller;

import assignment.book.dto.request.UserRequestDto;
import assignment.book.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserRequestDto userRequestDto){
        authService.signup(userRequestDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
