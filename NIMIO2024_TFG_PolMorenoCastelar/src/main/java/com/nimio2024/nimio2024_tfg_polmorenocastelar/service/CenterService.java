package com.nimio2024.nimio2024_tfg_polmorenocastelar.service;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Center;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.School;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.persistence.CenterRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;

@Service
public class CenterService {

    CenterRepository centerRepository;

    public CenterService(CenterRepository centerRepository) {
        this.centerRepository = centerRepository;
    }

    public ResponseEntity<List<Center>> getAllCenters() {
        if(centerRepository.findAll().isEmpty()){
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(centerRepository.findAll());
    }


    public Center getCenterById(Long id) {
        return centerRepository.findById(id).orElse(null);
    }


    public Center saveCenter(Center center) {
        return centerRepository.save(center);
    }


    public void deleteCenter(Long id) {
        centerRepository.deleteById(id);

    }

    public List<School> getSchoolsByCenterId(Long centerId) {
        Center center = centerRepository.findById(centerId).orElse(null);
        if(center == null){
            return null;
        }
        return center.getSchoolList();
    }
}
