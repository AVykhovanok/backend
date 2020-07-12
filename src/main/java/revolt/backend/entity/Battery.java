package revolt.backend.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "battery")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Battery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;

    @Column (name= "battery_name")
     String name;

    @Column (name= "battery_type")
     Integer type;

    @Column(name = "battery_apm")
     Integer apm;

    @Column (name="battery_price")
     Integer price;

    @Column(name = "battery_description", length = 1000)
     String description;

    @Column(name = "battery_picture")
     String picture;

    @ManyToOne
    @JoinColumn(name = "countryId")
    Country country;

    @ManyToOne
    @JoinColumn(name = "brandId")
    Brand brand;
}
