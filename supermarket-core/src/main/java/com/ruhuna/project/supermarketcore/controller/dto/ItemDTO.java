package com.ruhuna.project.supermarketcore.controller.dto;

import com.ruhuna.project.supermarketcore.entity.Pack;
import com.ruhuna.project.supermarketcore.entity.Unit;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/5/2018
 */
@Getter
@Setter
public class ItemDTO {
    private int id;
    @NotNull
    private String itemName;
    @NotNull
    private BigDecimal price;
    private String itemCode;
    private Double itemUnitSize;
    private String barcode;
    private Date expDate;
    private String description;
    private Pack pack;
    private Unit unit;
    private int itemSubTypeId;
}
