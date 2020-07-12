package revolt.backend.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "boxmod")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Boxmod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "boxmod_name")
    String name;

    @Column(name = "boxmod_batteryType")
    Integer batteryType;

    @Column(name = "boxmod_color")
    String color;

    @Column(name = "boxmod_price")
    Integer price;

    @Column(name = "boxmod_description", length = 1000)
    String description;

    @Column(name = "boxmod_picture")
    String picture;

    @ManyToOne
    @JoinColumn(name = "countryId")
    Country country;

    @ManyToOne
    @JoinColumn(name = "brandId")
    Brand brand;

}
