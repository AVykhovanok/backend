package revolt.backend.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "consumables")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Consumables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "consumables_name")
    String name;

    @Column(name = "consumables_diameter")
    Double diameter;

    @Column(name = "consumables_price")
    Integer price;

    @Column(name = "consumables_description", length = 1000)
    String description;

    @Column(name = "consumables_picture")
    String picture;

    @Column(name = "consumables_volume")
    Double volume;

    @Column(name = "consumables_weight")
    String weight;

    @ManyToOne
    @JoinColumn(name = "countryId")
    Country country;

    @ManyToOne
    @JoinColumn(name = "brandId")
    Brand brand;
}