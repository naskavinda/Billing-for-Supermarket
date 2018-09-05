package com.ruhuna.project.supermarketcore.service;

import com.ruhuna.project.supermarketcore.controller.dto.CartDTO;
import com.ruhuna.project.supermarketcore.controller.dto.ItemDTO;
import com.ruhuna.project.supermarketcore.controller.dto.ItemSubTypeDTO;
import com.ruhuna.project.supermarketcore.entity.ItemMainType;
import com.ruhuna.project.supermarketcore.entity.ItemSubType;

import java.util.List;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/4/2018
 */
public interface ItemService {
    List<ItemMainType> getAllItemMainType();

    ItemMainType getItemMainTypeById(int id);

    ItemMainType saveItemMainType(ItemMainType itemMainType);

    List<ItemSubType> getAllItemSubType();

    ItemSubType getItemSubTypeById(int id);

    ItemSubTypeDTO saveItemSubType(ItemSubTypeDTO itemSubTypeDTO);

    List<ItemDTO> getAllItem();

    ItemDTO getItemById(int id);

    ItemDTO saveItem(ItemDTO itemDTO);

    CartDTO getItemInCartById(int id);

    CartDTO addToCart(CartDTO cartDTO);

    List<CartDTO> getAllItemsInCart();
}
