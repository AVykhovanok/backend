package revolt.backend.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "complects")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Complects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "complects_name")
    String name;

    @Column(name = "complects_batteryType")
    Integer batteryType;

    @Column(name = "complects_color")
    String color;

    @Column(name = "complects_diameter")
    Double diameter;

    @Column(name = "complects_price")
    Integer price;

    @Column(name = "complects_description", length = 1000)
    String description;

    @Column(name = "complects_picture")
    String picture;

    @Column(name = "complects_value")
    String value;

    @ManyToOne
    @JoinColumn(name = "countryId")
    Country country;

    @ManyToOne
    @JoinColumn(name = "brandId")
    Brand brand;
}