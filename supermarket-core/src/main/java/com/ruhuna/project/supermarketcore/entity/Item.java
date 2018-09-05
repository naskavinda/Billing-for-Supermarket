package com.ruhuna.project.supermarketcore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "item")
public class Item implements Serializable {

    @Id
    @SequenceGenerator(name = "item_id_seq", sequenceName = "item_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "item_id_seq")
    private int id;

    @NotNull
    @ApiModelProperty(notes = "Item Name", required = true)
    private String itemName;

    @NotNull
    @ApiModelProperty(notes = "Item Unit Price", required = true)
    private BigDecimal price;

    @ApiModelProperty(notes = "Item Code", required = true)
    private String itemCode;

    @ApiModelProperty(notes = "Item Unit Size", required = true)
    private Double itemUnitSize;

    @ApiModelProperty(notes = "Item Barcode", required = true)
    private String barcode;

    @Temporal(TemporalType.DATE)
    @ApiModelProperty(notes = "Expiry date", required = true)
    private Date expDate;

    @ApiModelProperty(notes = "Description", required = true)
    @Length(max = 3000)
    private String description;

    @ApiModelProperty(notes = "Status", required = true)
    @Column(columnDefinition = "BOOLEAN default TRUE")
    private Boolean status;

//    @ElementCollection(targetClass = Pack.class)
//    @JoinTable(name = "tblShopTypes", joinColumns = @JoinColumn(name = "id"))
//    @Column(name = "pack", nullable = false)
    @Enumerated(EnumType.STRING)
    private Pack pack;

//    @ElementCollection(targetClass = Unit.class)
//    @JoinTable(name = "tblShopTypes", joinColumns = @JoinColumn(name = "id"))
//    @Column(name = "pack", nullable = false)
    @Enumerated(EnumType.STRING)
    private Unit unit;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private ItemSubType itemSubType;

}
