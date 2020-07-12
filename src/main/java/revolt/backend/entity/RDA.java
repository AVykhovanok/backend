package revolt.backend.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "rda")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RDA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "rda_name")
    String name;

    @Column(name = "rda_color")
    String color;

    @Column(name = "rda_diameter")
    Double diameter;

    @Column(name = "rda_price")
    Integer price;

    @Column(name = "rda_description", length = 1000)
    String description;

    @Column(name = "rda_picture")
    String picture;

    @Column(name = "rda_type_refill")
    String typeRefill;

    @ManyToOne
    @JoinColumn(name = "countryId")
    Country country;

    @ManyToOne
    @JoinColumn(name = "brandId")
    Brand brand;
}
