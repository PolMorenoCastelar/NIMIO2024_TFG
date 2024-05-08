package com.nimio2024.nimio2024_tfg_polmorenocastelar.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto.ClassDTO;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.application.exceptions.ScheduleAlreadyTakenException;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "classS")
public class ClassS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long class_id;

    @Column (name = "class_name")
    private String class_name;

    @Column (name = "class_number")
    private String class_number;

    @Column (name = "class_location")
    private String class_location;

    @OneToMany(mappedBy = "classS")
    @JsonIgnore
    private List<Schedule> schedule = new ArrayList<>();

    public ClassS() {
    }

    public ClassS(String class_name, String class_number, String class_location, List<Schedule> schedule) {
        this.class_name = class_name;
        this.class_number = class_number;
        this.class_location = class_location;
    }

    public ClassS(String class_name, String class_number, String class_location) {
        this.class_name = class_name;
        this.class_number = class_number;
        this.class_location = class_location;
    }

    public ClassS(ClassDTO classDTO){
        this.class_name = classDTO.getClassName();
        this.class_number = classDTO.getClassNumber();
        this.class_location = classDTO.getClassLocation();
    }

    public String getClassName() {
        return class_name;
    }

    public void setClassName(String class_name) {
        this.class_name = class_name;
    }

    public String getClassNumber() {
        return class_number;
    }

    public void setClassNumber(String class_number) {
        this.class_number = class_number;
    }

    public String getClassLocation() {
        return class_location;
    }

    public void setClassLocation(String class_location) {
        this.class_location = class_location;
    }


    public void checkSchedule(Schedule schedule) throws ScheduleAlreadyTakenException {
        double startHour = Double.parseDouble(schedule.getStartTimeClass());
        double endHour = Double.parseDouble(schedule.getEndTimeClass());
        for(Schedule s : this.schedule) {
            double startHourS = Double.parseDouble(s.getStartTimeClass());
            double endHourS = Double.parseDouble(s.getEndTimeClass());
            if((startHour >= startHourS && startHour <= endHourS) || (endHour >= startHourS && endHour <= endHourS)) {
                throw new ScheduleAlreadyTakenException("The schedule is already taken for this class, try another one ");
            }
        }
    }
}
