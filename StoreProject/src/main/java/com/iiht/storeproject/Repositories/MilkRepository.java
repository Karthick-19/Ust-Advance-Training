package com.iiht.storeproject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.storeproject.Entities.Milk;

@Repository
public interface MilkRepository extends JpaRepository<Milk,Long>{

}
