package com.iiht.storeproject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.storeproject.Entities.Egg;

@Repository
public interface EggRepository extends JpaRepository<Egg,Long>{

}
