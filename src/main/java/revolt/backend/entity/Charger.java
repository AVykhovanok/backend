package revolt.backend.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "charger")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Charger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column (name= "charger_name")
    String name;

    @Column(name = "charger_apm")
    Integer apm;

    @Column(name = "charger_numbOfBat")
    Integer numbOfBat;

    @Column(name = "charger_batteryType")
    Integer batteryType;

    @Column(name = "boxmod_color")
    String color;

    @Column (name="charger_price")
    Integer price;

    @Column(name = "charger_description", length = 1000)
    String description;

    @Column(name = "charger_picture")
    String picture;

    @ManyToOne
    @JoinColumn(name = "countryId")
    Country country;

    @ManyToOne
    @JoinColumn(name = "brandId")
    Brand brand;
}