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
        userResponseDto.setName(user.getName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPhone(user.getPhone());
        userResponseDto.setAvatar(user.getAvatar());
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
        user.setAvatar(userRequestDto.getAvatar());
        user.setIdentification_number(userRequestDto.getIdentification_number());
        user.setAddress(userRequestDto.getAddress());
        user.setPhone_number(userRequestDto.getPhone_number());
        user.setBank(userRequestDto.getBank());
        user.setBank_account_number(userRequestDto.getBank_account_number());


        return user;
    }
}
