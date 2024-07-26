package com.iiht.storeproject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.storeproject.Entities.Bread;

@Repository
public interface BreadRepository extends JpaRepository<Bread,Long>{

}
