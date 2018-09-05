package com.ruhuna.project.supermarketcore.entity;

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

    private double xCoordinate;

    private double yCoordinate;

    private double rackNo;

    private double rackSubNo;

    private double rackSide;

    private boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Item item;

}
