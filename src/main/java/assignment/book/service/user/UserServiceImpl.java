package assignment.book.service.user;

import assignment.book.dto.request.UserRequestDto;
import assignment.book.dto.response.UserResponseDto;
import assignment.book.entity.User;
import assignment.book.exception.NotFoundException;
import assignment.book.mapper.UserMapper;
import assignment.book.repository.UserRepository;
import assignment.book.service.uploadfile.UploadFileService;
import assignment.book.service.user.UserService;
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
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(userRequestDto.getUsername());
            user.setEmail(userRequestDto.getEmail());
            user.setName(userRequestDto.getName());
            user.setIdentification_number(userRequestDto.getIdentification_number());
            user.setAddress(userRequestDto.getAddress());
            user.setPhone_number(userRequestDto.getPhone_number());
            user.setBank(userRequestDto.getBank());
            user.setBank_account_number(userRequestDto.getBank_account_number());
            userRepository.save(user);
            UserResponseDto userResponseDto = userMapper.toUserResponseDto(user);
            return userResponseDto;
        }
        throw new NotFoundException("User with id = " + id + " not found");
    }
}
