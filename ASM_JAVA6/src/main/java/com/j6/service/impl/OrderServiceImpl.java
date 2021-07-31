package com.j6.service.impl;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j6.dao.OrderDAO;
import com.j6.dao.OrderDetailDAO;
import com.j6.entity.Order;
import com.j6.service.OrderService;


import java.util.List;
import com.j6.entity.OrderDetail;

@Service
public class OrderServiceImpl implements OrderService  {
	@Autowired
	OrderDAO orderDao;
	@Autowired
	OrderDetailDAO dtdao;
	@Override
	public Order create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper();
		Order order = mapper.convertValue(orderData, Order.class);
		orderDao.save(order);
		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
		List<OrderDetail> detail = mapper.convertValue(orderData.get("orderDetails"), type)
				.stream().peek(d-> d.setOrder(order)).collect(Collectors.toList());
		dtdao.saveAll(detail);
		return order;
	}
	@Override
	public Object findById(Long id) {
		return dtdao.findById(id).get();
	}

}
