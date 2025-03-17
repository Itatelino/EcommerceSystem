package com.itatechserviceweb.prototipo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itatechserviceweb.prototipo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
