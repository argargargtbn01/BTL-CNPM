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
@Table(name = "user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 50)
    private String username;
    @Column(nullable = false,length = 50)
    private String encoded_password;
    @Column(length = 50)
    private String email;
    @Column(length = 50)
    private String name;
    @Column(columnDefinition = "BLOB")
    private byte[] avatar;
    @Column(length = 50)
    private String identification_number;
    @Column(length = 200)
    private String address;
    @Column(length = 20)
    private String phone_number;
    @Column(length = 50)
    private String bank;
    @Column(length = 20)
    private String bank_account_number;

}
