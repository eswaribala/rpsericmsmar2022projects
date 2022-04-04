package com.eric.inventoryservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eric.inventoryservice.models.User;


public interface UserRepository extends JpaRepository<User,String>{

}
