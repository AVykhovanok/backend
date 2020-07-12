package revolt.backend.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "liquid")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Liquid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "liquid_name")
    String name;

    @Column(name = "liquid_nic")
    String nic;

    @Column(name = "liquid_price")
    Integer price;

    @Column(name = "liquid_description", length = 1000)
    String description;

    @Column(name = "liquid_picture")
    String picture;

    @Column(name = "liquid_value")
    String value;

    @ManyToOne
    @JoinColumn(name = "countryId")
    Country country;

    @ManyToOne
    @JoinColumn(name = "brandId")
    Brand brand;
}