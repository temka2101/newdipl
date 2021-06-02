package a.vkube.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "departurelocation")
public class DepartureLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int departureLocationID;

    @Column
    private String city;

    @Column
    private String village;

    @Column
    private String street;

    @Column
    private String house;

    @Column
    private String building;

    @Column
    private int entrance;

    @OneToMany(mappedBy = "departureLocation", fetch = FetchType.EAGER)
    Set<Order> orderSet;

    @Override
    public String toString() {
        return "DepartureLocation{" +
                "departureLocationID=" + departureLocationID +
                ", city='" + city + '\'' +
                ", village='" + village + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", building='" + building + '\'' +
                ", entrance=" + entrance +
                '}';
    }
}
