package com.ruhuna.project.supermarketcore.repository;

import com.ruhuna.project.supermarketcore.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/5/2018
 */
public interface CartRepository extends JpaRepository<Cart,Integer> {
    List<Cart> findCartsByStatusIsTrue();
}
