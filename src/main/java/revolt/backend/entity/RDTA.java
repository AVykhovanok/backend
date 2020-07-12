package revolt.backend.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "rdta")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RDTA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "rdta_name")
    String name;

    @Column(name = "rdta_color")
    String color;

    @Column(name = "rdta_diameter")
    Double diameter;

    @Column(name = "rdta_price")
    Integer price;

    @Column(name = "rdta_description", length = 1000)
    String description;

    @Column(name = "rdta_picture")
    String picture;

    @Column(name = "rdta_type_refill")
    String typeRefill;

    @Column(name = "rdta_volume")
    Double volume;

    @ManyToOne
    @JoinColumn(name = "countryId")
    Country country;

    @ManyToOne
    @JoinColumn(name = "brandId")
    Brand brand;
}
