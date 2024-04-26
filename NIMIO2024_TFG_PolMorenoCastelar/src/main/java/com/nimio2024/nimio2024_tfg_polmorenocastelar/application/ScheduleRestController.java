package com.nimio2024.nimio2024_tfg_polmorenocastelar.application;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers.ScheduleController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
public class ScheduleRestController {

    ScheduleController scheduleController;

    public ScheduleRestController(ScheduleController scheduleController) {
        this.scheduleController = scheduleController;
    }
}
