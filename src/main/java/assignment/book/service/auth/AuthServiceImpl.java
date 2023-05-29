package assignment.book.service.auth;

import assignment.book.dto.request.ProfileRequestDto;
import assignment.book.dto.response.ProfileResponseDto;
import assignment.book.entity.User;
import assignment.book.exception.NameAlreadyExistException;
import assignment.book.exception.NotFoundException;
import assignment.book.mapper.ProfileMapper;
import assignment.book.repository.AuthRepository;
import assignment.book.repository.ProfileRepository;
import assignment.book.service.uploadfile.UploadFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository;

    private final ProfileRepository userRepository;

    private final UploadFileService uploadFileService;
    private final ProfileMapper userMapper;

    @Override
    public void signup(ProfileRequestDto userRequestDto) {
        String username = userRequestDto.getUsername();
        Optional<User> checkUsernameExist = authRepository.findByUsername(username);
        if (checkUsernameExist.isPresent()) {
            throw new NameAlreadyExistException("Username already exists");
        }
        User user = userMapper.toUser(userRequestDto);
        userRepository.save(user);
    }

    @Override
    public Optional<ProfileResponseDto> login(String username, String password) {
        Optional<User> optionalUser = authRepository.findByUsername(username);
        User user = optionalUser.orElseThrow(() -> new NotFoundException("User not found"));
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPasswordInDatabase = user.getEncoded_password();
        if (passwordEncoder.matches(password, encodedPasswordInDatabase)) {
            ProfileResponseDto userResponseDto = userMapper.toUserResponseDto(user);
            return Optional.of(userResponseDto);
        }
        return Optional.empty();
    }
}
