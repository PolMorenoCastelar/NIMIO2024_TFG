package com.nimio2024.nimio2024_tfg_polmorenocastelar.service;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Center;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.persistence.CenterRepository;

import java.util.List;

@Service
public class CenterServiceImpl implements CenterService{

    @Autowired
    CenterRepository centerRepository;

    @Override
    public List<Center> getCenters() {
        return centerRepository.findAll();
    }

    @Override
    public Center createCenter(Center center) {
        return centerRepository.save(center);
    }

    @Override
    public Center getCenter(Long centerId) {
        return centerRepository.findById(centerId).orElse(null);
    }

    @Override
    public void deleteCenter(Long centerId) {
        centerRepository.deleteById(centerId);
    }
}
