package com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.ClassS;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Schedule;

import java.util.List;

public class ClassDTO {

    private String className;

    private String classNumber;

    private String classLocation;

    private List<Schedule> classSchedule;

    public ClassDTO() {
    }

    public ClassDTO(String className, String classNumber, String classLocation, List<Schedule> classSchedule) {
        this.className = className;
        this.classNumber = classNumber;
        this.classLocation = classLocation;
        this.classSchedule = classSchedule;
    }

   public ClassDTO (ClassS classS){
        this.className = classS.getClassName();
        this.classNumber = classS.getClassNumber();
        this.classLocation = classS.getClassLocation();
        this.classSchedule = classS.getClassSchedule();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getClassLocation() {
        return classLocation;
    }

    public void setClassLocation(String classLocation) {
        this.classLocation = classLocation;
    }

    public List<Schedule> getClassSchedule() {
        return classSchedule;
    }

    public void setClassSchedule(List<Schedule> classSchedule) {
        this.classSchedule = classSchedule;
   }

}
