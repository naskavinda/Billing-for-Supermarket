package com.ruhuna.project.supermarketcore.manager.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/4/2018
 */
@Getter
@Setter
@Entity
@Table(name = "item_list")
public class ItemList {
    @Id
    @SequenceGenerator(name = "item_list_id_seq", sequenceName = "item_list_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "item_list_id_seq")
    private int id;

    @Temporal( TemporalType.DATE )
    private Date itemSelectDate;

    @Column( columnDefinition = "INT default 1" )
    private boolean status;

    @JsonIgnoreProperties( {"hibernateLazyInitializer", "handler"} )
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Customer customer;
}
