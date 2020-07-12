package revolt.backend.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "rta")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RTA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "rta_name")
    String name;

    @Column(name = "rta_color")
    String color;

    @Column(name = "rta_diameter")
    Double diameter;

    @Column(name = "rta_price")
    Integer price;

    @Column(name = "rta_description", length = 1000)
    String description;

    @Column(name = "rta_picture")
    String picture;

    @Column(name = "rta_type_refill")
    String typeRefill;

    @Column(name = "rta_volume")
    Double volume;

    @ManyToOne
    @JoinColumn(name = "countryId")
    Country country;

    @ManyToOne
    @JoinColumn(name = "brandId")
    Brand brand;
}