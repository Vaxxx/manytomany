package ng.com.createsoftware.manytomany.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name="book")
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(cascade= CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(
            name="book_author",
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name="author_id")
    )
    @ToString.Exclude
    private List<Author> authors = new ArrayList<>();

    @ManyToOne(cascade= CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name="category_id")
    @ToString.Exclude
    private  Category  category ;

    public Book(String name, List<Author> authors, Category category) {
        this.name = name;
        this.authors = authors;
        this.category = category;
    }

    public void addAuthor(Author author){
        authors.add(author);
    }

    public void deleteAuthor(Author author){
        authors.remove(author);
    }
}
