package manager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/2/2018
 */
@Getter
@Setter
@Entity
@Table(name = "item_location")
public class ItemLocation {
    @Id
    @SequenceGenerator(name = "item_location_id_seq", sequenceName = "item_location_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "item_location_id_seq")
    private int id;

    @Column(name = "x_coordinate")
    private double xCoordinate;

    @Column(name = "y_coordinate")
    private double yCoordinate;

    @Column(name = "rack_no")
    private double rackNo;

    @Column(name = "rack_sub_no")
    private double rackSubNo;

    @Column(name = "rack_side")
    private double rackSide;

    @Column(name = "status")
    private boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Item item;

}
