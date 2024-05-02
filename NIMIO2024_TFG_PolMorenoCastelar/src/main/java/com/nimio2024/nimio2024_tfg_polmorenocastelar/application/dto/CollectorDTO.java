package com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Collector;

public class CollectorDTO {

    private Long studentID;

    private Long personID;

    private String collectedDate;

    private String collectedTime;


    public CollectorDTO() {
    }

    public CollectorDTO(Long studentID, Long personID, String collectedDate, String collectedTime) {
        this.studentID = studentID;
        this.personID = personID;
        this.collectedDate = collectedDate;
        this.collectedTime = collectedTime;
    }

    public CollectorDTO(Collector collector) {
        this.studentID = collector.getStudentId();
        this.personID = collector.getPersonId();
        this.collectedDate = collector.getCollectedDate();
        this.collectedTime = collector.getCollectedTime();
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public Long getPersonID() {
        return personID;
    }

    public void setPersonID(Long personID) {
        this.personID = personID;
    }

    public String getCollectedDate() {
        return collectedDate;
    }

    public void setCollectedDate(String collectedDate) {
        this.collectedDate = collectedDate;
    }

    public String getCollectedTime() {
        return collectedTime;
    }

    public void setCollectedTime(String collectedTime) {
        this.collectedTime = collectedTime;
    }
}
