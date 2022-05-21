package com.example.demo.Register.Repository;

import com.example.demo.Register.Models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    @Query(value = "select * from admin where username=:username", nativeQuery = true)
    Optional<Admin> findAdminByUsername(@Param("username") String username);

    @Query(value = "select * from admin where username=:username and password=:password", nativeQuery = true)
    Optional<Admin> findAdminByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
