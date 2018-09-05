package com.ruhuna.project.supermarketcore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "item_main_type")
public class ItemMainType implements Serializable {
    @Id
    @SequenceGenerator(name = "item_main_type_id_seq", sequenceName = "item_main_type_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "item_main_type_id_seq")
    private int id;

    @NotNull(message = "Type Can't be null")
    @ApiModelProperty(notes = "Type", required = true)
    private String type;

    @JsonIgnore
    @ApiModelProperty(notes = "Status", required = true)
    @Column(columnDefinition = "BOOLEAN default TRUE")
    private Boolean status;
}
