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
@Table(name = "book")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(nullable = false,length = 50)
  private long owner_ID;
  @Column(nullable = false, length = 50)
  private String isbn;
  @Column(nullable = false, length = 50)
  private String author;
  @Column(nullable = false, length = 50)
  private String description;
  @Column(nullable = false, length = 50)
  private float price;
  @Column(nullable = false, length = 50)
  private String category;
  @Column(nullable = false, length = 50)
  private int status;
}
