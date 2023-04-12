package assignment.book.controller;

import assignment.book.dto.request.UserRequestDto;
import assignment.book.dto.response.UserResponseDto;
import assignment.book.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping(value = "/signup", consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
    public ResponseEntity<?> signup(@RequestParam("file") MultipartFile file, @ModelAttribute UserRequestDto userRequestDto){
        authService.signup(userRequestDto,file);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username,@RequestParam String password){
        Optional<UserResponseDto> userResponseDto = authService.login(username, password);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }
}
