package com.ruhuna.project.supermarketcore.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer {
    @Id
    @SequenceGenerator(name = "customer_id_seq", sequenceName = "customer_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "customer_id_seq")
    private int id;

    @NotNull(message = "First Name Can't be Null")
    @ApiModelProperty(notes = "First Name", required = true)
    private String firstName;

    @ApiModelProperty(notes = "Last Name")
    private String lastName;

    @NotNull(message = "Telephone Number Can't be null")
    @ApiModelProperty(notes = "Telephone Number", required = true)
    private String tp;

    @ApiModelProperty(notes = "Status", required = true)
    @Column(columnDefinition = "BOOLEAN default TRUE")
    private Boolean status;

}
