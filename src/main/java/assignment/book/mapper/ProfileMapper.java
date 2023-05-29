package assignment.book.mapper;

import assignment.book.dto.request.ProfileRequestDto;
import assignment.book.dto.response.ProfileResponseDto;
import assignment.book.entity.Profile;
import assignment.book.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper {
    public ProfileResponseDto toProfileResponseDto (Profile profile){
        ProfileResponseDto profileResponseDto = new ProfileResponseDto();
        profileResponseDto.setId(profile.getId());
        profileResponseDto.setEmail(profile.getEmail());
        profileResponseDto.setName(profile.getName());
        profileResponseDto.setIdentification_number(profile.getIdentification_number());
        profileResponseDto.setAddress(profile.getAddress());
        profileResponseDto.setPhone_number(profile.getPhone_number());
        profileResponseDto.setBank(profile.getBank());
        profileResponseDto.setBank_account_number(profile.getBank_account_number());
        return profileResponseDto;
    }

    public Profile toProfile (ProfileRequestDto profileRequestDto){
        Profile profile = new Profile();
        profile.setEmail(profileRequestDto.getEmail());
        profile.setName(profileRequestDto.getName());
        profile.setIdentification_number(profileRequestDto.getIdentification_number());
        profile.setAddress(profileRequestDto.getAddress());
        profile.setPhone_number(profileRequestDto.getPhone_number());
        profile.setBank(profileRequestDto.getBank());
        profile.setBank_account_number(profileRequestDto.getBank_account_number());
        return profile;
    }
}
