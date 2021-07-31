package com.j6.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.j6.entity.Order;

@Service
public interface OrderService {
	Order create(JsonNode orderData);

	Object findById(Long id);
}
