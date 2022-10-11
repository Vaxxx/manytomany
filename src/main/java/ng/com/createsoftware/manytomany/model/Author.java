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
public class Author {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(cascade= CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name="zipcode_id")
    @ToString.Exclude
    private  Zipcode  zipcode ;

    @ManyToMany(mappedBy = "category",cascade= CascadeType.ALL, fetch=FetchType.LAZY)
    @ToString.Exclude
    private List<Book> books = new ArrayList<>();




    public Author(String name,Zipcode zipcode, List<Book> books) {
        this.name = name;
        this.books = books;
        this.zipcode = zipcode;
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(Book book){
        books.remove(book);
    }
}
