package assignment.book.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileResponseDto {
    private Long id;
    private String email;
    private String name;
    private String identification_number;
    private String address;
    private String phone_number;
    private String bank;
    private String bank_account_number;
}
