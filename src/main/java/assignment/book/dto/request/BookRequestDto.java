package assignment.book.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDto {
    private Long owner_id;
    private String ISBN;
    private String image_Link;
    private String author;
    private String description;
    private String price;
    private String category;
}
