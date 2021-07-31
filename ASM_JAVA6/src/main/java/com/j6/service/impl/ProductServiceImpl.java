package com.j6.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.j6.dao.CategoryDAO;
import com.j6.dao.ProductDao;
import com.j6.entity.Product;
import com.j6.service.ProductService;

@Controller
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao pdao;

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return pdao.findAll();
	}

	@Override
	public Product findByID(Integer id) {
		// TODO Auto-generated method stub
		return pdao.findById(id).get();
	}

	@Override
	public List<Product> finByCategoryId(String cid) {
		return pdao.finByCategoryId(cid);
	}
}
