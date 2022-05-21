package com.example.demo.Register.Repository;

import com.example.demo.Register.Models.RoomFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RoomFeatureRepository extends JpaRepository<RoomFeature,Integer> {

    @Modifying
    @Transactional
    @Query(value = "select * from room_feature r where r.room_type=?1", nativeQuery = true)
    List<RoomFeature> getRoomFeaturesByRoomType(String roomType);

}
