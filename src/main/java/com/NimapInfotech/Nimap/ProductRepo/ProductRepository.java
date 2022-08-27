package com.NimapInfotech.Nimap.ProductRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.NimapInfotech.Nimap.ProductEntity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
