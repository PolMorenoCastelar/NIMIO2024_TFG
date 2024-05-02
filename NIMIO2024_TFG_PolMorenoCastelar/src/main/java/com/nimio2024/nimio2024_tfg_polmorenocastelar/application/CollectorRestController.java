package com.nimio2024.nimio2024_tfg_polmorenocastelar.application;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers.CollectorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collectors")
public class CollectorRestController {

    CollectorController collectorController;

    public CollectorRestController(CollectorController collectorController) {
        this.collectorController = collectorController;
    }


}
