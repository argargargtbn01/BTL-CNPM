package assignment.book.service;

import assignment.book.dto.request.UserRequestDto;
import assignment.book.entity.User;
import assignment.book.mapper.UserMapper;
import assignment.book.repository.AuthRepository;
import assignment.book.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository;

    private final UserRepository userRepository;


    private final UserMapper userMapper;
    @Override
    public void signup(UserRequestDto userRequestDto) {
        User user = userMapper.toUser(userRequestDto);
        userRepository.save(user);
    }
}
