package com.nimio2024.nimio2024_tfg_polmorenocastelar.application;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.ScheduleDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.ClassDoNotExistException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.CourseDoNotExistException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers.ScheduleController;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Schedule;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleRestController {

    ScheduleController scheduleController;

    public ScheduleRestController(ScheduleController scheduleController) {
        this.scheduleController = scheduleController;
    }

    @PostMapping("/{courseId}/{classId}")
    public Schedule createSchedule(@PathVariable Long courseId, @PathVariable Long classId, @RequestBody ScheduleDTO scheduleDTO) throws CourseDoNotExistException, ClassDoNotExistException {
        return scheduleController.createSchedule(courseId, classId, scheduleDTO);
    }

    @GetMapping("/{scheduleId}")
    public Schedule getSchedule(@PathVariable Long scheduleId) {
        return scheduleController.getScheduleById(scheduleId);
    }

    @GetMapping ("/course/{courseId}")
    public List<Schedule> getScheduleByCourse(@PathVariable Long courseId){
        return scheduleController.getScheduleByCourse(courseId);
    }

    @GetMapping ("/class/{classId}")
    public List<Schedule> getScheduleByClass(@PathVariable Long classId){
        return scheduleController.getScheduleByClass(classId);
    }
}
