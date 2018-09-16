package com.ruhuna.project.supermarketcore.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/2/2018
 */
@Getter
@Setter
@Entity
@Table(name = "payment")
public class Payment {
    @Id
//    @SequenceGenerator(name = "payment_id_seq", sequenceName = "payment_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)//, generator = "payment_id_seq")
    @Column(name = "payment_id")
    private int paymentId;

    private BigDecimal paidAmount;

    private BigDecimal grossAmount;

    private BigDecimal discount;

    private boolean isDiscountRate;

    private BigDecimal netAmount;

    private BigDecimal balance;

    private boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id", referencedColumnName = "bill_id", nullable = false)
    private Bill bill;
}
