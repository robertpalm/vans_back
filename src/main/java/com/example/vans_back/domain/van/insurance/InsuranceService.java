package com.example.vans_back.domain.van.insurance;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class InsuranceService {

    @Resource
    private InsuranceRepository insuranceRepository;

    public void addInsurance(Insurance insurance) {
        insuranceRepository.save(insurance);
    }

    public Insurance findInsuranceBy(String insuranceProvider) {
        return insuranceRepository.findInsuranceBy(insuranceProvider);
    }

    public boolean insuranceExistsByProvider(String insuranceProvider) {
        return insuranceRepository.insuranceExistsByProvider(insuranceProvider);
    }
}
