package com.nimio2024.nimio2024_tfg_polmorenocastelar.application;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.CenterDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.CenterAlreadyExistsException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.CenterDoNotExistException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers.CenterController;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Center;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.School;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/centers")
public class CenterRestController {

    CenterController centerController;

    public CenterRestController(CenterController centerController) {this.centerController = centerController;}

    @GetMapping("")
    public ResponseEntity<List<Center>> getAllCenters() throws CenterDoNotExistException {
        return centerController.getAllCenters();
    }
    @GetMapping("/{centerId}/schools")
    public List<School> getSchoolsByCenter(@PathVariable Long centerId) throws CenterDoNotExistException {
        return centerController.getSchoolsByCenter(centerId);
    }
    @PostMapping("")
    public Center createCenter(@RequestBody CenterDTO centerDTO) throws CenterAlreadyExistsException {
        return centerController.createCenter(centerDTO);
    }
    @PutMapping("/{centerId}")
    public Center updateCenter(@PathVariable Long centerId, @RequestBody CenterDTO centerDTO) throws CenterDoNotExistException {
        return centerController.updateCenter(centerId, centerDTO);
    }
    @DeleteMapping("/{centerId}")
    public void deleteCenter(@PathVariable Long centerId) {
        centerController.deleteCenter(centerId);
    }


}
