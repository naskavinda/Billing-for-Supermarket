package com.ruhuna.project.supermarketcore.service.impl;

import com.ruhuna.project.supermarketcore.controller.dto.CartDTO;
import com.ruhuna.project.supermarketcore.controller.dto.ItemDTO;
import com.ruhuna.project.supermarketcore.controller.dto.ItemSubTypeDTO;
import com.ruhuna.project.supermarketcore.entity.*;
import com.ruhuna.project.supermarketcore.exception.InvalidPropertyException;
import com.ruhuna.project.supermarketcore.repository.CartRepository;
import com.ruhuna.project.supermarketcore.repository.ItemMainTypeRepository;
import com.ruhuna.project.supermarketcore.repository.ItemRepository;
import com.ruhuna.project.supermarketcore.repository.ItemSubTypeRepository;
import com.ruhuna.project.supermarketcore.service.CustomerService;
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
    private final CartRepository cartRepository;

    private final CustomerService customerService;

    @Autowired
    public ItemServiceImpl(ItemMainTypeRepository itemMainTypeRepository, ItemSubTypeRepository itemSubTypeRepository, ItemRepository itemRepository, CartRepository cartRepository, CustomerService customerService) {
        this.itemMainTypeRepository = itemMainTypeRepository;
        this.itemSubTypeRepository = itemSubTypeRepository;
        this.itemRepository = itemRepository;
        this.cartRepository = cartRepository;
        this.customerService = customerService;
    }

    @Override
    public List<ItemMainType> getAllItemMainType() {
        return itemMainTypeRepository.findAll();
    }

    @Override
    public ItemMainType getItemMainTypeById(int id) {
        Optional<ItemMainType> itemMainType = itemMainTypeRepository.findById(id);
        if (!itemMainType.isPresent())
            throw new InvalidPropertyException("provided Item Main Type ID is not exist.");
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
            throw new InvalidPropertyException("provided Item Sub Type ID is not exist.");
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
        return ItemModelMapper.itemToItemDAO(findItemById(id));
    }

    private Item findItemById(int id) {
        Optional<Item> item = itemRepository.findById(id);
        if (!item.isPresent())
            throw new InvalidPropertyException("provided Item ID is not exist.");
        return item.get();
    }

    @Override
    public ItemDTO saveItem(ItemDTO itemDTO) {
        ItemSubType itemSubType = getItemSubTypeById(itemDTO.getItemSubTypeId());

        Item item = ItemModelMapper.itemDTOToItem(itemDTO, itemSubType, true);
        return ItemModelMapper.itemToItemDAO(itemRepository.save(item));
    }

    @Override
    public CartDTO getItemInCartById(int id) {
        Optional<Cart> cart = cartRepository.findById(id);
        if (!cart.isPresent())
            throw new InvalidPropertyException("provided Item ID is not exist.");
        return ItemModelMapper.cartToCartDTO(cart.get());
    }

    @Override
    public CartDTO addToCart(CartDTO cartDTO) {
        Item item = findItemById(cartDTO.getItemId());
        Customer customer = customerService.getCustomerById(cartDTO.getCustomerId());
        return ItemModelMapper.cartToCartDTO(cartRepository.save(ItemModelMapper.cartDTOToCart(cartDTO, customer, item, true)));
    }

    @Override
    public List<CartDTO> getAllItemsInCart() {
        return cartRepository.findCartsByStatusIsTrue().stream().map(ItemModelMapper::cartToCartDTO).collect(Collectors.toList());
    }
}
