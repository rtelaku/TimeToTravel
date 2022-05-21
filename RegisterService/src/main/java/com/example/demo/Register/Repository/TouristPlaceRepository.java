package com.example.demo.Register.Repository;

import com.example.demo.Register.Models.TouristPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TouristPlaceRepository extends JpaRepository<TouristPlace,Integer> {
    @Modifying
    @Transactional
    @Query(value = "select name from tourist_place", nativeQuery = true)
    List<String> getTouristPlacesNames();

    @Query(value = "select * from tourist_place t where t.city_id=?1", nativeQuery = true)
    List<TouristPlace> getTouristPlacesByCityId(int cityId);

}
