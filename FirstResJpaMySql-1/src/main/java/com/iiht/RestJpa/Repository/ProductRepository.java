package com.iiht.RestJpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.RestJpa.Entities.Product;

@Repository
public interface ProductRepository extends  JpaRepository<Product, Long>{

}
