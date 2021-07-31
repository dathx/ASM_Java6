package com.j6.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.j6.entity.Order;
import com.j6.service.OrderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/order")
public class OrderRestController {
	@Autowired
	OrderService orderService;
	
	@PostMapping()
	public Order create(@RequestBody JsonNode orderData) {
		return ((OrderService) orderData).create(orderData);
	}
}
