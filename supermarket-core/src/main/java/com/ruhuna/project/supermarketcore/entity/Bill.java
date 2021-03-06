package com.ruhuna.project.supermarketcore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "bill")
public class Bill {
    @Id
//    @SequenceGenerator(name = "bill_id_seq", sequenceName = "bill_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)//, generator = "bill_id_seq")
    @Column(name = "bill_id")
    private int billId;

    @NotNull
    @ApiModelProperty(notes = "Total Bill", required = true)
    private BigDecimal totalBill;

    @ApiModelProperty(notes = "Total Discount", required = true)
    private BigDecimal totalDiscount;

    @Column(columnDefinition = "BOOLEAN default TRUE")
    private Boolean isDiscountRate;

    @ApiModelProperty(notes = "Status", required = true)
    @Column(columnDefinition = "BOOLEAN default TRUE")
    private Boolean status;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private Users users;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    private Customer customer;


}
