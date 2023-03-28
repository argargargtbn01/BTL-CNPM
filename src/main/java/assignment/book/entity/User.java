package assignment.book.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
  @Column(nullable = false, length = 50)
  private String password;
  @Column(length = 50)
  private String email;
  @Column(nullable = false, length = 50)
  private String name;
  @Column(nullable = true, length = 50)
  private String avatar;
  @Column(length = 50)
  private String identification_number;
  @Column(length = 50)
  private String address;
  @Column(length = 50)
  private String phone_number;
  @Column(length = 50)
  private String bank;
  @Column(length = 50)
  private String bank_account_number;
}
