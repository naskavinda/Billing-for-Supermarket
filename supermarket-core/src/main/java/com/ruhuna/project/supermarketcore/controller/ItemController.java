package com.ruhuna.project.supermarketcore.controller;

import com.ruhuna.project.supermarketcore.entity.ItemMainType;
import com.ruhuna.project.supermarketcore.entity.ItemSubType;
import com.ruhuna.project.supermarketcore.service.ItemService;
import com.ruhuna.project.supermarketcore.service.dto.ItemSubTypeDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/4/2018
 */
@RestController
@Api(value = "Item", tags = "items")
@Consumes(MediaType.APPLICATION_JSON_UTF8_VALUE)
@Produces(MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(value = "item_main_type/")
    @ApiOperation(value = "All Item Main Type", response = ItemMainType.class, responseContainer = "List")
    public ResponseEntity<List<ItemMainType>> getAllItemMainType() {
        List<ItemMainType> allItemMainType = itemService.getAllItemMainType();
        if (allItemMainType.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allItemMainType, HttpStatus.OK);
    }

    @GetMapping(value = "item_main_type/{id}")
    @ApiOperation(value = "Get Item Main Type By ID", response = ItemMainType.class)
    public ResponseEntity<ItemMainType> getItemMainTypeById(@PathVariable int id) {
        return itemService.getItemMainTypeById(id)
                .map(itemMainType -> new ResponseEntity<>(itemMainType, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping(value = "item_main_type/")
    @ApiOperation(value = "Save Item Main Type details", response = ItemMainType.class)
    public ResponseEntity<ItemMainType> saveItemMainType(@RequestBody ItemMainType itemMainType) {
        ItemMainType itemMainTypeResponse = itemService.saveItemMainType(itemMainType);
        return new ResponseEntity<>(itemMainTypeResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "item_sub_type/")
    @ApiOperation(value = "All Item Sub Type", response = ItemMainType.class, responseContainer = "List")
    public ResponseEntity<List<ItemSubType>> getAllItemSubType() {
        List<ItemSubType> allItemSubType = itemService.getAllItemSubType();
        if (allItemSubType.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allItemSubType, HttpStatus.OK);
    }

    @GetMapping(value = "item_sub_type/{id}")
    @ApiOperation(value = "Get Item Sub Type By ID", response = ItemSubType.class)
    public ResponseEntity<ItemSubType> getItemSubTypeById(@PathVariable int id) {
        return itemService.getItemSubTypeById(id)
                .map(itemSubType -> new ResponseEntity<>(itemSubType, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping(value = "item_sub_type/")
    @ApiOperation(value = "Save Item Sub Type details", response = ItemSubTypeDTO.class)
    public ResponseEntity<ItemSubTypeDTO> saveItemSubType(@RequestBody ItemSubTypeDTO itemSubTypeDTO) {
        ItemSubTypeDTO itemSubTypeDTOResponse = itemService.saveItemSubType(itemSubTypeDTO);
        return new ResponseEntity<>(itemSubTypeDTOResponse, HttpStatus.CREATED);
    }
}
