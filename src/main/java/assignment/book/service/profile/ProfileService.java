package assignment.book.service.profile;

import assignment.book.dto.request.ProfileRequestDto;
import assignment.book.dto.response.ProfileResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface ProfileService {
    ProfileResponseDto getProfile (Long id);

    ProfileResponseDto updateProfile (Long id , ProfileRequestDto userRequestDto);
}
