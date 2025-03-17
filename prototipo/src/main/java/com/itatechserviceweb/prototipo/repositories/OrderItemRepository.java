package com.itatechserviceweb.prototipo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itatechserviceweb.prototipo.entities.OrderItem;
import com.itatechserviceweb.prototipo.entities.pk.OrderItemPK;


public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
