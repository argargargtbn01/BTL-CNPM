package assignment.book.service;

import assignment.book.dto.request.UserRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    void signup (UserRequestDto userRequestDto);
}
