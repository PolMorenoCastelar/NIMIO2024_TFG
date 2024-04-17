package com.nimio2024.nimio2024_tfg_polmorenocastelar.application;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.CenterDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers.CenterController;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Center;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.CenterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/centers")
public class CenterRestController {

    CenterController centerController;

    public CenterRestController(CenterController centerController) {this.centerController = centerController;}

    @GetMapping("")
    public ResponseEntity<List<Center>> getAllCenters() {
        return centerController.getAllCenters();
    }

    @PostMapping("")
    public Center createCenter(@RequestBody CenterDTO centerDTO) {
        return centerController.createCenter(centerDTO);
    }

}
