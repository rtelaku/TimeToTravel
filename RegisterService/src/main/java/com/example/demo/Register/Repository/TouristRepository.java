package com.example.demo.Register.Repository;

import com.example.demo.Register.Models.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TouristRepository extends JpaRepository<Tourist, Integer> {

    @Query(value = "select * from tourist where username=?1", nativeQuery = true)
    Optional<Tourist> findTouristByUsername(String username);

    @Query(value = "select * from tourist where username=:username and password=:password", nativeQuery = true)
    Optional<Tourist> findTouristByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
