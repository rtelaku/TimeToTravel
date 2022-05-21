package com.example.demo.Register.Repository;

import com.example.demo.Register.Models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {

    @Modifying
    @Transactional
    @Query(value = "select name from city", nativeQuery = true)
    List<String> getCitiesNames();

    @Query(value = "select id from city", nativeQuery = true)
    List<Integer> getCitiesIds();

    @Query(value = "select * from city c where c.name=?1", nativeQuery = true)
    City findCityByName(String name);
}
