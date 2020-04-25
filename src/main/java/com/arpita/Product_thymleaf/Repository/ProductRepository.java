package com.arpita.Product_thymleaf.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arpita.Product_thymleaf.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
