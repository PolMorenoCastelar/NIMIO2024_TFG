package com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.CenterDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Center;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.School;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.CenterService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CenterController {

    CenterService centerService;

    public CenterController(CenterService centerService) {
        this.centerService = centerService;
    }

    public ResponseEntity<List<Center>> getAllCenters() {
        return centerService.getAllCenters();
    }

    public Center createCenter(CenterDTO centerDTO) {
        if(centerService.getCenterByName(centerDTO.getCenterName()).isPresent()) {
            //throw new IllegalArgumentException("Center already exists"); //TODO: THROW O SYSERR?
            System.err.println("Center already exists, check the name");
            return null;
        }
        Center center = new Center(centerDTO);
        return centerService.saveCenter(center);
    }

    public Center updateCenter(Long centerId, CenterDTO centerDTO) {
        Center center = centerService.getCenterById(centerId);
        center.setCenterName(centerDTO.getCenterName());
        return centerService.saveCenter(center);
    }

    public List<School> getSchoolsByCenter(Long centerId) {
        if(centerService.getCenterById(centerId) == null) {
            //throw new IllegalArgumentException("Center not found"); //TODO: THROW O SYSERR?
            System.err.println("Center not found, check the center id");
            return null;
        }
        return centerService.getSchoolsByCenterId(centerId);
    }

    public void deleteCenter(Long centerId) {
        centerService.deleteCenter(centerId);
    }
}
