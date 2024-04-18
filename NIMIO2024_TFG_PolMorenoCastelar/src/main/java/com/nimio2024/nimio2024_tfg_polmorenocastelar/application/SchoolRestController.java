package com.nimio2024.nimio2024_tfg_polmorenocastelar.application;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.SchoolDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers.SchoolController;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.School;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schools")
public class SchoolRestController {

    SchoolController schoolController;

    public SchoolRestController(SchoolController schoolController) {this.schoolController = schoolController;}

    @PostMapping("/{centerId}")
    public School createSchool(@RequestBody SchoolDTO schoolDTO, @PathVariable Long centerId){
       return schoolController.createSchool(schoolDTO, centerId);
    }
}
