package com.ruhuna.project.supermarketcore.service.impl;

import com.ruhuna.project.supermarketcore.controller.dto.ItemDTO;
import com.ruhuna.project.supermarketcore.controller.dto.ItemSubTypeDTO;
import com.ruhuna.project.supermarketcore.entity.Item;
import com.ruhuna.project.supermarketcore.entity.ItemMainType;
import com.ruhuna.project.supermarketcore.entity.ItemSubType;
import com.ruhuna.project.supermarketcore.exception.InvalidPropertyException;
import com.ruhuna.project.supermarketcore.repository.ItemMainTypeRepository;
import com.ruhuna.project.supermarketcore.repository.ItemRepository;
import com.ruhuna.project.supermarketcore.repository.ItemSubTypeRepository;
import com.ruhuna.project.supermarketcore.service.ItemService;
import com.ruhuna.project.supermarketcore.service.util.ItemModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/4/2018
 */
@Service("itemService")
@Transactional
public class ItemServiceImpl implements ItemService {

    private final ItemMainTypeRepository itemMainTypeRepository;
    private final ItemSubTypeRepository itemSubTypeRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemMainTypeRepository itemMainTypeRepository, ItemSubTypeRepository itemSubTypeRepository, ItemRepository itemRepository) {
        this.itemMainTypeRepository = itemMainTypeRepository;
        this.itemSubTypeRepository = itemSubTypeRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public List<ItemMainType> getAllItemMainType() {
        return itemMainTypeRepository.findAll();
    }

    @Override
    public ItemMainType getItemMainTypeById(int id) {
        Optional<ItemMainType> itemMainType = itemMainTypeRepository.findById(id);
        if (!itemMainType.isPresent())
            throw new InvalidPropertyException("You provided Item Main Type ID is not exist.");
        return itemMainType.get();
    }

    @Override
    public ItemMainType saveItemMainType(ItemMainType itemMainType) {
        itemMainType.setStatus(true);
        return itemMainTypeRepository.save(itemMainType);
    }

    @Override
    public List<ItemSubType> getAllItemSubType() {
        return itemSubTypeRepository.findAll();
    }

    @Override
    public ItemSubType getItemSubTypeById(int id) {
        Optional<ItemSubType> itemSubType = itemSubTypeRepository.findById(id);
        if (!itemSubType.isPresent())
            throw new InvalidPropertyException("You provided Item Sub Type ID is not exist.");
        return itemSubType.get();
    }

    @Override
    public ItemSubTypeDTO saveItemSubType(ItemSubTypeDTO itemSubTypeDTO) {
        ItemMainType itemMainType = getItemMainTypeById(itemSubTypeDTO.getItemMainTypeId());

        ItemSubType itemSubType = ItemModelMapper.itemSubTypeDTOToItemSubType(itemSubTypeDTO, itemMainType, true);
        return ItemModelMapper.itemSubTypeToItemSubTypeDTO(itemSubTypeRepository.save(itemSubType));
    }


    @Override
    public List<ItemDTO> getAllItem() {
        return itemRepository.findAll().stream().map(ItemModelMapper::itemToItemDAO).collect(Collectors.toList());
    }

    @Override
    public ItemDTO getItemById(int id) {
        Optional<Item> item = itemRepository.findById(id);
        if (!item.isPresent())
            throw new InvalidPropertyException("You provided Item ID is not exist.");
        return ItemModelMapper.itemToItemDAO(item.get());
    }

    @Override
    public ItemDTO saveItem(ItemDTO itemDTO) {
        ItemSubType itemSubType = getItemSubTypeById(itemDTO.getItemSubTypeId());

        Item item = ItemModelMapper.itemDTOToItem(itemDTO, itemSubType, true);
        return ItemModelMapper.itemToItemDAO(itemRepository.save(item));
    }
}
