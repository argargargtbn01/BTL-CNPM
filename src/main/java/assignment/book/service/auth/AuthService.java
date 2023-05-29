package assignment.book.service.auth;

import assignment.book.dto.request.ProfileRequestDto;
import assignment.book.dto.response.ProfileResponseDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AuthService {
    void signup (ProfileRequestDto userRequestDto);

    Optional<ProfileResponseDto> login(String username, String password);

}
