package com.ruhuna.project.supermarketcore.service.impl;

import com.ruhuna.project.supermarketcore.entity.ItemMainType;
import com.ruhuna.project.supermarketcore.entity.ItemSubType;
import com.ruhuna.project.supermarketcore.exception.InvalidPropertyException;
import com.ruhuna.project.supermarketcore.repository.ItemMainTypeRepository;
import com.ruhuna.project.supermarketcore.repository.ItemSubTypeRepository;
import com.ruhuna.project.supermarketcore.service.ItemService;
import com.ruhuna.project.supermarketcore.service.dto.ItemSubTypeDTO;
import com.ruhuna.project.supermarketcore.service.util.ItemModelMapper;
import com.sun.javaws.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/4/2018
 */
@Service( "itemService" )
@Transactional
public class ItemServiceImpl implements ItemService {

    private final ItemMainTypeRepository itemMainTypeRepository;
    private final ItemSubTypeRepository itemSubTypeRepository;

    @Autowired
    public ItemServiceImpl(ItemMainTypeRepository itemMainTypeRepository, ItemSubTypeRepository itemSubTypeRepository) {
        this.itemMainTypeRepository = itemMainTypeRepository;
        this.itemSubTypeRepository = itemSubTypeRepository;
    }

    @Override
    public List<ItemMainType> getAllItemMainType() {
        return itemMainTypeRepository.findAll();
    }

    @Override
    public Optional<ItemMainType> getItemMainTypeById(int id) {
        return itemMainTypeRepository.findById(id);
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
    public Optional<ItemSubType> getItemSubTypeById(int id) {
        return itemSubTypeRepository.findById(id);
    }

    @Override
    public ItemSubTypeDTO saveItemSubType(ItemSubTypeDTO itemSubTypeDTO) {
        Optional<ItemMainType> itemMainType = getItemMainTypeById(itemSubTypeDTO.getItemMainTypeId());
        if (!itemMainType.isPresent()) {
            throw new InvalidPropertyException("Item main type is not exist.");
        }
        ItemSubType itemSubType = ItemModelMapper.itemSubTypeDTOToItemSubType(itemSubTypeDTO, itemMainType.get(),true);
        return ItemModelMapper.itemSubTypeToItemSubTypeDTO(itemSubTypeRepository.save(itemSubType));
    }
}
