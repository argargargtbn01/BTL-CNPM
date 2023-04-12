package assignment.book.service;

import assignment.book.dto.request.UserRequestDto;
import assignment.book.dto.response.UserResponseDto;
import assignment.book.entity.User;
import assignment.book.exception.NotFoundException;
import assignment.book.mapper.UserMapper;
import assignment.book.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final UploadFileService uploadFileService;

    @Override
    public UserResponseDto getUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.orElseThrow(() -> new NotFoundException("user with id = " + id +  " not found"));
        UserResponseDto userResponseDto = userMapper.toUserResponseDto(user);
        return userResponseDto;
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {
        return null;
    }
}
