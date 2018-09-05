package com.ruhuna.project.supermarketcore.repository;

import com.ruhuna.project.supermarketcore.entity.ItemMainType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/4/2018
 */
@Repository
public interface ItemMainTypeRepository extends JpaRepository<ItemMainType,Integer> {
}
