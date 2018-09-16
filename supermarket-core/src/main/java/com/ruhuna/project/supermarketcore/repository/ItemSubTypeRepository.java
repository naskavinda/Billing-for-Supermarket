package com.ruhuna.project.supermarketcore.repository;

import com.ruhuna.project.supermarketcore.entity.ItemSubType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/4/2018
 */
public interface ItemSubTypeRepository extends JpaRepository<ItemSubType,Integer> {
    public List<ItemSubType> findItemSubTypesByItemMainType_ItemMainTypeId(int id);

    Optional<ItemSubType> findByItemSubTypeId(int id);
}
