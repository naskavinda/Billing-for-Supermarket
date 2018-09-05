package com.ruhuna.project.supermarketcore.service;

import com.ruhuna.project.supermarketcore.entity.ItemMainType;
import com.ruhuna.project.supermarketcore.entity.ItemSubType;
import com.ruhuna.project.supermarketcore.controller.dto.ItemSubTypeDTO;

import java.util.List;
import java.util.Optional;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/4/2018
 */
public interface ItemService {
    List<ItemMainType> getAllItemMainType();

    Optional<ItemMainType> getItemMainTypeById(int id);

    ItemMainType saveItemMainType(ItemMainType itemMainType);

    List<ItemSubType> getAllItemSubType();

    Optional<ItemSubType> getItemSubTypeById(int id);

    ItemSubTypeDTO saveItemSubType(ItemSubTypeDTO itemSubTypeDTO);
}
