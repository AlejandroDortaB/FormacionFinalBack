package com.rr.plates;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodPlatesRepository extends JpaRepository<FoodPlates,Integer>{

}
