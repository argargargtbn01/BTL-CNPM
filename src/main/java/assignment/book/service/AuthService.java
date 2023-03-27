package assignment.book.service;

import assignment.book.dto.request.UserRequestDto;

public interface AuthService {
    void signup (UserRequestDto userRequestDto);
}
