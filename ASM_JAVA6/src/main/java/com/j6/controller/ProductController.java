package com.j6.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.j6.entity.Product;
import com.j6.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productservice;

	@RequestMapping("/product/list")
	public String list(Model model, @RequestParam("cid") Optional<String> cid) {
		if (cid.isPresent()) {
			List<Product> list = productservice.finByCategoryId(cid.get());
			model.addAttribute("items", list);
		} else {
			List<Product> list = productservice.findAll();
			model.addAttribute("items", list);
		}

		return "product/list";
	}

	@RequestMapping("/product/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Product item = productservice.findByID(id);
		model.addAttribute("item", item);
		return "product/detail";
	}
}
