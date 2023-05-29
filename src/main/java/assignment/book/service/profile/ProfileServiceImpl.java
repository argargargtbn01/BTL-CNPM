package assignment.book.service.profile;

import assignment.book.dto.request.ProfileRequestDto;
import assignment.book.dto.response.ProfileResponseDto;
import assignment.book.entity.Profile;
import assignment.book.entity.User;
import assignment.book.exception.NotFoundException;
import assignment.book.mapper.ProfileMapper;
import assignment.book.repository.ProfileRepository;
import assignment.book.service.uploadfile.UploadFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;

    private final ProfileMapper profileMapper;

    private final UploadFileService uploadFileService;

    @Override
    public ProfileResponseDto getProfile(Long id) {
        Optional<Profile> optionalProfile = profileRepository.findById(id);
        Profile profile = optionalProfile.orElseThrow(() -> new NotFoundException("profile with id = " + id +  " not found"));
        ProfileResponseDto profileResponseDto = profileMapper.toProfileResponseDto(profile);
        return profileResponseDto;
    }

    @Override
    public ProfileResponseDto updateProfile(Long id, ProfileRequestDto userRequestDto) {
        Optional<Profile> optionalProfile = profileRepository.findById(id);
        if (optionalProfile.isPresent()) {
            Profile profile = optionalProfile.get();
            profile.setEmail(userRequestDto.getEmail());
            profile.setName(userRequestDto.getName());
            profile.setIdentification_number(userRequestDto.getIdentification_number());
            profile.setAddress(userRequestDto.getAddress());
            profile.setPhone_number(userRequestDto.getPhone_number());
            profile.setBank(userRequestDto.getBank());
            profile.setBank_account_number(userRequestDto.getBank_account_number());
            profileRepository.save(profile);
            ProfileResponseDto profileResponseDto = profileMapper.toProfileResponseDto(profile);
            return profileResponseDto;
        }
        throw new NotFoundException("User with id = " + id + " not found");
    }
}
