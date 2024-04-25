package com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.CenterDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.CenterAlreadyExistsException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.CenterDoNotExistException;
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

    public ResponseEntity<List<Center>> getAllCenters() throws CenterDoNotExistException {
        if(centerService.getAllCenters() == null){
           throw new CenterDoNotExistException("There are no centers");
        }
        return centerService.getAllCenters();
    }

    public Center createCenter(CenterDTO centerDTO) throws CenterAlreadyExistsException {
        if(centerService.getCenterByName(centerDTO.getCenterName()).isPresent()) {
            throw new CenterAlreadyExistsException("Center with name "+ centerDTO.getCenterName() +" already exists");
        }
        Center center = new Center(centerDTO);
        return centerService.saveCenter(center);
    }

    public Center updateCenter(Long centerId, CenterDTO centerDTO) throws CenterDoNotExistException {
        Center center = centerService.getCenterById(centerId);
        if(center == null){
            throw new CenterDoNotExistException("Center with id "+ centerId +" does not exist");
        }
        center.setCenterName(centerDTO.getCenterName());
        return centerService.saveCenter(center);
    }

    public List<School> getSchoolsByCenter(Long centerId) throws CenterDoNotExistException {
        if(centerService.getCenterById(centerId) == null) {
            throw new CenterDoNotExistException("Center with id "+ centerId +" does not exist");
        }
        return centerService.getSchoolsByCenterId(centerId);
    }

    public void deleteCenter(Long centerId) {
        centerService.deleteCenter(centerId);
    }
}
