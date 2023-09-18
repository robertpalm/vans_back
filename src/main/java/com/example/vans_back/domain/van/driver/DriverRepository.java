package com.example.vans_back.domain.van.driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

    List<Driver> findByVan_Id(Integer id);

    @Query("select d from Driver d where d.user.id = ?1")
    Optional<Driver> findDriverByUserId(Integer userId);

    @Query("select d from Driver d where d.id = ?1")
    Optional<Driver> findDriverByDriverId(Integer driverId);

    @Query("select d from Driver d where (d.city.id = ?1 or ?1 = 0) and (d.id = ?2 or ?2 = 0) and d.status = ?3 order by d.city.name, d.name")
    List<Driver> findDriversBy(Integer cityId, Integer driverId, String status);

    @Query("select d from Driver d where d.status = ?1 order by d.city.name, d.name")
    List<Driver> findDriversBy(String status);
}