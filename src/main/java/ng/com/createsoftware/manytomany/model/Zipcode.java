package ng.com.createsoftware.manytomany.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name="zipcode")
@NoArgsConstructor
public class Zipcode {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(cascade= CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name="city_id", referencedColumnName = "id")
    @ToString.Exclude
    private City city;


    public Zipcode(String name, City city) {
        this.name = name;
        this.city = city;
    }
}
