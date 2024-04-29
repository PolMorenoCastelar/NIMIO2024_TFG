package com.nimio2024.nimio2024_tfg_polmorenocastelar.service;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Schedule;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.persistence.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public Schedule getScheduleById(Long scheduleId) {
        return scheduleRepository.findById(scheduleId).orElse(null);
    }
}
