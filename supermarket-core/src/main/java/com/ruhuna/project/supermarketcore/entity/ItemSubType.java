package com.ruhuna.project.supermarketcore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "item_sub_type")
public class ItemSubType implements Serializable {
    @Id
    @SequenceGenerator(name = "item_sub_type_id_seq", sequenceName = "item_sub_type_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "item_sub_type_id_seq")
    private int id;

    @NotNull(message = "Type Can't be null")
    @ApiModelProperty(notes = "Type", required = true)
    private String type;

    @ApiModelProperty(notes = "Status", required = true)
    @Column(columnDefinition = "BOOLEAN default TRUE")
    private Boolean status;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private ItemMainType itemMainType;

}
