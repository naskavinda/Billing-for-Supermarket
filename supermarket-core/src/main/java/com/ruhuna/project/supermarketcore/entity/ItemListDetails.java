package com.ruhuna.project.supermarketcore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/4/2018
 */
@Getter
@Setter
@Entity
@Table(name = "item_list_details")
public class ItemListDetails {
    @Id
    @SequenceGenerator(name = "item_list_details_id_seq", sequenceName = "item_list_details_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "item_list_details_id_seq")
    private int id;

    private double qty;

    @Column( columnDefinition = "INT default 1" )
    private boolean status;

    @JsonIgnoreProperties( {"hibernateLazyInitializer", "handler"} )
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private ItemList itemList;

    @JsonIgnoreProperties( {"hibernateLazyInitializer", "handler"} )
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Item item;
}
