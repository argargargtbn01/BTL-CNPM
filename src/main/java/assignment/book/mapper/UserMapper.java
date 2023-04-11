package assignment.book.mapper;

import assignment.book.dto.request.UserRequestDto;
import assignment.book.dto.response.UserResponseDto;
import assignment.book.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto toUserResponseDto (User user){
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setUsername(user.getUsername());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setName(user.getName());
        userResponseDto.setAvatar(user.getAvatar());
        userResponseDto.setIdentification_number(user.getIdentification_number());
        userResponseDto.setAddress(user.getAddress());
        userResponseDto.setPhone_number(user.getPhone_number());
        userResponseDto.setBank(user.getBank());
        userResponseDto.setBank_account_number(user.getBank_account_number());
        return userResponseDto;
    }

    public User toUser (UserRequestDto userRequestDto){
        User user = new User();
        user.setUsername(userRequestDto.getUsername());
        String password = userRequestDto.getPassword();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        user.setEncoded_password(encodedPassword);
        user.setEmail(userRequestDto.getEmail());
        user.setName(userRequestDto.getName());
        user.setIdentification_number(userRequestDto.getIdentification_number());
        user.setAddress(userRequestDto.getAddress());
        user.setPhone_number(userRequestDto.getPhone_number());
        user.setBank(userRequestDto.getBank());
        user.setBank_account_number(userRequestDto.getBank_account_number());
        return user;
    }
}
