package assignment.book.service;

import assignment.book.dto.request.UserRequestDto;
import assignment.book.dto.response.UserResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface AuthService {
    void signup (UserRequestDto userRequestDto, MultipartFile file);

//    UserResponseDto login(String username, String password);

}
