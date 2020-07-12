package revolt.backend.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "mechmod")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Mechmod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "mechmod_name")
    String name;

    @Column(name = "mechmod_batteryType")
    Integer batteryType;

    @Column(name = "mechmod_color")
    String color;

    @Column(name = "mechmod_diameter")
    Double diameter;

    @Column(name = "mechmod_price")
    Integer price;

    @Column(name = "mechmod_description", length = 1000)
    String description;

    @Column(name = "mechmod_picture")
    String picture;

    @ManyToOne
    @JoinColumn(name = "countryId")
    Country country;

    @ManyToOne
    @JoinColumn(name = "brandId")
    Brand brand;
}