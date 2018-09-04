package com.ruhuna.project.supermarketcore.manager.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "item_main_type")
public class ItemMainType {
    @Id
    @SequenceGenerator(name = "item_main_type_id_seq", sequenceName = "item_main_type_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "item_main_type_id_seq")
    private int id;

    @NotNull(message = "Type Can't be null")
    @ApiModelProperty(notes = "Type", required = true)
    private String type;

    @ApiModelProperty(notes = "Status", required = true)
    @Column(columnDefinition = "BOOLEAN default TRUE")
    private Boolean status;
}
