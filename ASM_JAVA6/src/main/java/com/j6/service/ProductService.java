package com.j6.service;

import java.util.List;
import java.util.Optional;

import com.j6.entity.Product;

public interface ProductService  {

	List<Product> findAll();

	Product findByID(Integer id);

	List<Product> finByCategoryId(String cid);



}
