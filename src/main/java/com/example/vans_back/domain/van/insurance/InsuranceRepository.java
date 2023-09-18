package com.example.vans_back.domain.van.insurance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {
    @Query("select (count(i) > 0) from Insurance i where i.provider = ?1")
    boolean insuranceExistsByProvider(String providerName);

    @Query("select i from Insurance i where i.provider = ?1")
    Insurance findInsuranceBy(String providerName);
}