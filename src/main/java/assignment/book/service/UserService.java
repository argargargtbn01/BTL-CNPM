package assignment.book.service;

import assignment.book.dto.request.UserRequestDto;
import assignment.book.dto.response.UserResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserResponseDto getUser (Long id);

    UserResponseDto updateUser (Long id , UserRequestDto userRequestDto);
}
