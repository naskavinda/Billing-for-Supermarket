package com.ruhuna.project.supermarketcore.service.util;

import com.ruhuna.project.supermarketcore.entity.ItemMainType;
import com.ruhuna.project.supermarketcore.entity.ItemSubType;
import com.ruhuna.project.supermarketcore.service.dto.ItemSubTypeDTO;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/5/2018
 */
public final class ItemModelMapper {

    private ItemModelMapper() {
    }


    public static ItemSubType itemSubTypeDTOToItemSubType(ItemSubTypeDTO itemSubTypeDTO, ItemMainType itemMainType,boolean status) {
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
}
