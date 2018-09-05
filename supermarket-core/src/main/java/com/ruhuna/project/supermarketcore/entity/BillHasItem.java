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
@Table(name = "bill_has_item")
public class BillHasItem {
    @Id
    @SequenceGenerator(name = "bill_has_item_id_seq", sequenceName = "bill_has_item_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "bill_has_item_id_seq")
    private int id;

    @Column(name = "qty")
    private Double qty;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "is_discount_rate")
    private BigDecimal isDiscountRate;

    @Column(name = "status")
    private boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Bill bill;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Item item;

}
