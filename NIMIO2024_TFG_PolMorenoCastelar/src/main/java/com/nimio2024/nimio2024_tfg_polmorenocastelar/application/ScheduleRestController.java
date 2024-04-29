package com.nimio2024.nimio2024_tfg_polmorenocastelar.application;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.ScheduleDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.CourseDoNotExistException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers.ScheduleController;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Schedule;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
public class ScheduleRestController {

    ScheduleController scheduleController;

    public ScheduleRestController(ScheduleController scheduleController) {
        this.scheduleController = scheduleController;
    }

    @PostMapping("/{courseId}/{classId}")
    public Schedule createSchedule(@PathVariable Long courseId, @PathVariable Long classId, @RequestBody ScheduleDTO scheduleDTO) throws CourseDoNotExistException {
        return scheduleController.createSchedule(courseId, classId, scheduleDTO);
    }

    @GetMapping("/{scheduleId}")
    public Schedule getSchedule(@PathVariable Long scheduleId){
        return scheduleController.getScheduleById(scheduleId);
    }
}
