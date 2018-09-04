package com.ruhuna.project.supermarketcore.manager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/2/2018
 */
@Getter
@Setter
@Entity
@Table(name = "payment_type")
public class PaymentType {

    @Id
    @SequenceGenerator(name = "payment_type_id_seq", sequenceName = "payment_type_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "payment_type_id_seq")
    private int id;

    @NotNull
    private String type;

    @NotNull
    @Column( columnDefinition = "INT default 1" )
    private boolean status;
}