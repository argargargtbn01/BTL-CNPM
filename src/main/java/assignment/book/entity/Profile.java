package assignment.book.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "profile")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Profile {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200)
    private String email;
    @Column(length = 200)
    private String name;
    @Column(length = 200)
    private String identification_number;
    @Column(length = 200)
    private String address;
    @Column(length = 20)
    private String phone_number;
    @Column(length = 200)
    private String bank;
    @Column(length = 200)
    private String bank_account_number;
}
