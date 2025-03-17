package com.itatechserviceweb.prototipo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itatechserviceweb.prototipo.entities.Order;
import com.itatechserviceweb.prototipo.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> List = service.findAll();
		return ResponseEntity.ok().body(List);
	}
	
	@GetMapping(value = "/(id)")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = (Order) service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
