package com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.CenterDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Center;
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
        Center center = new Center(centerDTO);
        return centerService.saveCenter(center);
    }

    public Center updateCenter(Long centerId, CenterDTO centerDTO) {
        Center center = centerService.getCenterById(centerId);
        center.setCenterName(centerDTO.getCenterName());
        return centerService.saveCenter(center);
    }
}
