package assignment.book.service;

import assignment.book.dto.request.UserRequestDto;
import assignment.book.dto.response.UserResponseDto;
import assignment.book.entity.User;
import assignment.book.mapper.UserMapper;
import assignment.book.repository.AuthRepository;
import assignment.book.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository;

    private final UserRepository userRepository;

    private final UploadFileService uploadFileService;
    private final UserMapper userMapper;
    @Override
    public void signup(UserRequestDto userRequestDto, MultipartFile file) {
        User user = userMapper.toUser(userRequestDto);
        String avatar = uploadFileService.uploadFile(file);
        user.setAvatar(avatar);
        userRepository.save(user);
    }

//    @Override
//    public UserResponseDto login(String username,String password) {
//
//    }
}
