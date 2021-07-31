package com.j6.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;

import com.j6.entity.Product;


public interface ProductDao extends JpaRepository<Product, Integer>{

	@Query("select p from Product p where p.category.id=?1")
	List<Product> finByCategoryId(String cid);

}
