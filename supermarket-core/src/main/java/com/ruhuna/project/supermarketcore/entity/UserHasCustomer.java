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
@Table(name = "user_has_customer")
public class UserHasCustomer {
    @Id
    @SequenceGenerator(name = "user_has_customer_id_seq", sequenceName = "user_has_customer_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_has_customer_id_seq")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Customer customer;

    private boolean status;
}
