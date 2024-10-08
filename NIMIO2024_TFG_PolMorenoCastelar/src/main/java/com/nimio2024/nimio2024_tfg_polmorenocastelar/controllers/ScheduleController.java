package com.nimio2024.nimio2024_tfg_polmorenocastelar.controllers;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.ScheduleDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.ClassDoNotExistException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.CourseDoNotExistException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.ScheduleAlreadyTakenException;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.ClassS;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Course;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Schedule;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.ClassService;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.CourseService;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.ScheduleService;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class ScheduleController {

    ScheduleService scheduleService;
    CourseService courseService;
    ClassService classService;

    public ScheduleController(ScheduleService scheduleService, CourseService courseService, ClassService classService) {
        this.scheduleService = scheduleService;
        this.classService = classService;
        this.courseService = courseService;
    }


    public Schedule createSchedule(Long courseId, Long classId, ScheduleDTO scheduleDTO) throws CourseDoNotExistException, ClassDoNotExistException, ScheduleAlreadyTakenException {
        Course course = courseService.getCourseById(courseId);
        if(course == null) {
            throw new CourseDoNotExistException("Course with id " + courseId + " do not exist");
        }
        ClassS classS = classService.getClassById(classId);
        if(classS == null) {
            throw new ClassDoNotExistException("Class with id " + classId + " do not exist");
        }
        Schedule schedule = new Schedule(scheduleDTO);

        classS.checkSchedule(schedule);
        schedule.setCourse(course);
        schedule.setClassS(classS);

        return scheduleService.saveSchedule(schedule);




    }

    public Schedule getScheduleById(Long scheduleId) {
        return scheduleService.getScheduleById(scheduleId);
    }

    public List<Schedule> getScheduleByCourse(Long courseId) {
        List<Schedule> allSchedule = scheduleService.findAllSchedule();
        List<Schedule> courseSchedule = new ArrayList<Schedule>();
        for(Schedule schedule : allSchedule) {
            if(schedule.getCourse() == courseService.getCourseById(courseId)) {
                courseSchedule.add(schedule);
                System.out.println(schedule);
            }
        }
        return courseSchedule;
    }

    public List<Schedule> getScheduleByClass(Long classId) {
        List<Schedule> allSchedule = scheduleService.findAllSchedule();
        List<Schedule> classSchedule = new ArrayList<Schedule>();
        for(Schedule schedule : allSchedule) {
            if(schedule.getClassS() == classService.getClassById(classId)) {
                classSchedule.add(schedule);
                System.out.println(schedule);
            }
        }
        return classSchedule;
    }

    public void deleteSchedule(Long scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
    }
}
