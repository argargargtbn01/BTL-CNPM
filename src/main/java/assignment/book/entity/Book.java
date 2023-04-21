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
@Table(name = "book")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    private Long owner_id;
    @Column(length = 50)
    private String ISBN;
    @Column(length = 200)
    private String image_Link;
    @Column(length = 50)
    private String author;
    @Column(length = 200)
    private String description;
    @Column(length = 20)
    private String price;
    @Column(length = 20)
    private String category;
    @Column(length = 10)
    private int status; // 0 : available , 1 : sold
}
