package com.nimio2024.nimio2024_tfg_polmorenocastelar.aplication;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Center;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.persistence.CenterRepository;

import java.util.List;

@Service
public class CenterServiceImpl implements CenterService {

    CenterRepository centerRepository;

    public CenterServiceImpl(CenterRepository centerRepository){

        this.centerRepository = centerRepository;
    }

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
