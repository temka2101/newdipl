package a.vkube.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int orderID;

    @Column
    private LocalDateTime dateOfReceipt;

    @Column
    private LocalDateTime dateOfAppointment;

    @Column
    private String phone;

    @Column
    private String cost;

    @ManyToMany(mappedBy = "orderSet" , fetch = FetchType.EAGER)
    private Set<Driver> driverSet;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departurelocation_ID")
    private DepartureLocation departureLocation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "destinationlocation_ID")
    private DestinationLocation destinationLocation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_ID")
    private Status status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tariff_ID")
    private Tariff tariff;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cars_ID")
    private Car car;

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", dateOfReceipt=" + dateOfReceipt +
                ", dateOfAppointment=" + dateOfAppointment +
                ", phone='" + phone + '\'' +
                ", cost='" + cost + '\'' +
                ", driverSet=" + driverSet +
                ", departureLocation=" + departureLocation +
                ", destinationLocation=" + destinationLocation +
                ", status=" + status +
                ", tariff=" + tariff +
                ", car=" + car +
                '}';
    }
}
