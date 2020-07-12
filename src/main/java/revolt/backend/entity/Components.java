package revolt.backend.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "components")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Components {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "components_name")
    String name;

    @Column(name = "components_price")
    Integer price;

    @Column(name = "components_description", length = 1000)
    String description;

    @Column(name = "components_nic", length = 1000)
    String nic;

    @Column(name = "components_picture")
    String picture;

    @Column(name = "components_value")
    String value;

    @ManyToOne
    @JoinColumn(name = "countryId")
    Country country;

    @ManyToOne
    @JoinColumn(name = "brandId")
    Brand brand;

}
