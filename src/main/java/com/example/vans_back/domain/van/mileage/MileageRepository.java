package com.example.vans_back.domain.van.mileage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface MileageRepository extends JpaRepository<Mileage, Integer> {

    @Query("select m from Mileage m where (m.van.id = ?1 or ?1 = 0) and m.date between ?2 and ?3 order by m.date, m.van.id")
    List<Mileage> findMileagesBy(Integer vanId, LocalDate startDate, LocalDate endDate);

    @Query("select (count(m) > 0) from Mileage m where m.date = ?1 and m.van.id = ?2")
    boolean dateForVanExistsBy(LocalDate date, Integer id);
}