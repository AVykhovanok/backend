package revolt.backend.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "country")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "country_name")
    String name;

    @OneToMany(mappedBy="country", cascade = CascadeType.ALL)
    private List<Accessories> accessories = new ArrayList<>();

    @OneToMany(mappedBy="country", cascade = CascadeType.ALL)
    private List<Battery> batteries = new ArrayList<>();

    @OneToMany(mappedBy="country", cascade = CascadeType.ALL)
    private List<Boxmod> boxmods = new ArrayList<>();

    @OneToMany(mappedBy="country", cascade = CascadeType.ALL)
    private List<Charger> chargers = new ArrayList<>();

    @OneToMany(mappedBy="country", cascade = CascadeType.ALL)
    private List<Complects> complects = new ArrayList<>();

    @OneToMany(mappedBy="country", cascade = CascadeType.ALL)
    private List<Components> components = new ArrayList<>();

    @OneToMany(mappedBy="country", cascade = CascadeType.ALL)
    private List<Consumables> consumables = new ArrayList<>();

    @OneToMany(mappedBy="country", cascade = CascadeType.ALL)
    private List<Liquid> liquids = new ArrayList<>();

    @OneToMany(mappedBy="country", cascade = CascadeType.ALL)
    private List<Mechmod> mechmods = new ArrayList<>();

    @OneToMany(mappedBy="country", cascade = CascadeType.ALL)
    private List<RDA> rdas = new ArrayList<>();

    @OneToMany(mappedBy="country", cascade = CascadeType.ALL)
    private List<RDTA> rdtas = new ArrayList<>();

    @OneToMany(mappedBy="country", cascade = CascadeType.ALL)
    private List<RTA> rtas = new ArrayList<>();
}
