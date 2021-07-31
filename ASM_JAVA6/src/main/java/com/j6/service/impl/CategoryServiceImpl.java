package com.j6.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j6.dao.CategoryDAO;
import com.j6.entity.Category;
import com.j6.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDAO cdao;

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return cdao.findAll();
	}
	
	
}
