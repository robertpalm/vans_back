package com.example.vans_back.domain.van.driver;

import com.example.vans_back.business.Status;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    @Resource
    private DriverRepository driverRepository;

    public Driver getDriverByUserId(Integer userId) {
        return driverRepository.findDriverByUserId(userId).get();
    }

    public Driver getDriverByDriverId(Integer driverId) {
        return driverRepository.findDriverByDriverId(driverId).get();
    }

    public void addDriver(Driver driver) {
        driverRepository.save(driver);
    }

    public List<Driver> findDriversBy(Integer vanId) {
        return driverRepository.findByVan_Id(vanId);
    }

    public void saveAllDrivers(List<Driver> drivers) {
        driverRepository.saveAll(drivers);
    }

    public List<Driver> getActiveDriversBy(Integer cityId, Integer driverId) {
        return driverRepository.findDriversBy(cityId, driverId, Status.ACTIVE.getLetter());
    }

    public List<Driver> findAllActiveDrivers() {
        return driverRepository.findDriversBy(Status.ACTIVE.getLetter());
    }

    public void deactivateDriver(Driver driver) {
        driver.setVan(null);
        driver.setStatus(Status.DELETED.getLetter());
        driverRepository.save(driver);
    }
}


