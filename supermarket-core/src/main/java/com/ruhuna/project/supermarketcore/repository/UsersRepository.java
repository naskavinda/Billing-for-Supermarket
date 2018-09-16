package com.ruhuna.project.supermarketcore.repository;

import com.ruhuna.project.supermarketcore.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/3/2018
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findUsersByUserId(int id);
}
