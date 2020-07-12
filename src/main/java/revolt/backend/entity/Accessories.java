package revolt.backend.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "accessories")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Accessories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "accessories_name")
    String name;

    @Column(name = "accessories_batteryType")
    Integer batteryType;

    @Column(name = "accessories_color")
    String color;

    @Column(name = "accessories_numbOfBat")
    Integer numbOfBat;

    @Column(name = "accessories_diameter")
    Double diameter;

    @Column(name = "accessories_price")
    Integer price;

    @Column(name = "accessories_description", length = 1000)
    String description;

    @Column(name = "accessories_picture")
    String picture;

    @ManyToOne
    @JoinColumn(name = "countryId")
    Country country;

    @ManyToOne
    @JoinColumn(name = "brandId")
    Brand brand;
}
