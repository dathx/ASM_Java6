package com.j6.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.j6.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Long>{

}
