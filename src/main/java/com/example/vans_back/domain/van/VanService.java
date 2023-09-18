package com.example.vans_back.domain.van;

import com.example.vans_back.business.Status;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VanService {

    @Resource
    private VanRepository vanRepository;

    public List<Van> getActiveVansBy(Integer cityId, Integer vanId) {
        return vanRepository.findVansBy(cityId, vanId, Status.ACTIVE.getLetter());
    }

    public void addVan(Van van) {
        vanRepository.save(van);
    }

    public void deactivateVan(Integer vanId) {
        Van van = vanRepository.findById(vanId).get();
        van.setStatus(Status.DELETED.getLetter());
        vanRepository.save(van);
    }

    public List<Van> getAllVans() {
        return vanRepository.findVansBy(Status.ACTIVE.getLetter());
    }
}
