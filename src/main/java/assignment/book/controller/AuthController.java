package assignment.book.controller;

import assignment.book.dto.request.UserRequestDto;
import assignment.book.dto.response.UserResponseDto;
import assignment.book.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping(value = "/signup")
    public ResponseEntity<?> signup(@ModelAttribute UserRequestDto userRequestDto){
        authService.signup(userRequestDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username,@RequestParam String password){
        Optional<UserResponseDto> userResponseDto = authService.login(username, password);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

}
