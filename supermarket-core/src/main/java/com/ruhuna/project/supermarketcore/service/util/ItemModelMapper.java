package com.ruhuna.project.supermarketcore.service.util;

import com.ruhuna.project.supermarketcore.controller.dto.ItemDTO;
import com.ruhuna.project.supermarketcore.controller.dto.ItemSubTypeDTO;
import com.ruhuna.project.supermarketcore.entity.Item;
import com.ruhuna.project.supermarketcore.entity.ItemMainType;
import com.ruhuna.project.supermarketcore.entity.ItemSubType;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/5/2018
 */
public final class ItemModelMapper {

    private ItemModelMapper() {
    }


    public static ItemSubType itemSubTypeDTOToItemSubType(ItemSubTypeDTO itemSubTypeDTO, ItemMainType itemMainType, boolean status) {
        ItemSubType itemSubType = new ItemSubType();
        itemSubType.setId(itemSubTypeDTO.getId());
        itemSubType.setItemMainType(itemMainType);
        itemSubType.setType(itemSubTypeDTO.getType());
        itemSubType.setStatus(status);
        return itemSubType;
    }

    public static ItemSubTypeDTO itemSubTypeToItemSubTypeDTO(ItemSubType itemSubType) {
        ItemSubTypeDTO itemSubTypeDTO = new ItemSubTypeDTO();
        itemSubTypeDTO.setId(itemSubType.getId());
        itemSubTypeDTO.setItemMainTypeId(itemSubType.getItemMainType().getId());
        itemSubTypeDTO.setType(itemSubType.getType());
        return itemSubTypeDTO;
    }

    public static Item itemDTOToItem(ItemDTO itemDTO, ItemSubType itemSubType, boolean status) {
        Item item = new Item();
        item.setId(itemDTO.getId());
        item.setItemName(itemDTO.getItemName());
        item.setItemCode(itemDTO.getItemCode());
        item.setBarcode(itemDTO.getBarcode());
        item.setExpDate(itemDTO.getExpDate());
        item.setDescription(itemDTO.getDescription());
        item.setItemSubType(itemSubType);
        item.setItemUnitSize(itemDTO.getItemUnitSize());
        item.setPack(itemDTO.getPack());
        item.setPrice(itemDTO.getPrice());
        item.setUnit(itemDTO.getUnit());
        item.setStatus(status);
        return item;
    }

    public static ItemDTO itemToItemDAO(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        itemDTO.setItemName(item.getItemName());
        itemDTO.setItemCode(item.getItemCode());
        itemDTO.setBarcode(item.getBarcode());
        itemDTO.setExpDate(item.getExpDate());
        itemDTO.setDescription(item.getDescription());
        itemDTO.setItemSubTypeId(item.getItemSubType().getId());
        itemDTO.setItemUnitSize(item.getItemUnitSize());
        itemDTO.setPack(item.getPack());
        itemDTO.setPrice(item.getPrice());
        itemDTO.setUnit(item.getUnit());
        return itemDTO;
    }
}
