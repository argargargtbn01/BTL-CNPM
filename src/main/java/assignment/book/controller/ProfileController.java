package assignment.book.controller;

import assignment.book.dto.request.ProfileRequestDto;
import assignment.book.dto.response.ProfileResponseDto;
import assignment.book.service.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUser(@PathVariable long id){
        ProfileResponseDto userResponseDto = profileService.getProfile(id);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateUser(@PathVariable long id, @RequestBody ProfileRequestDto userRequestDto){
        ProfileResponseDto userResponseDto = profileService.updateProfile(id,userRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }
}
