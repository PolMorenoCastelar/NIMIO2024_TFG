package com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Collector;

public class CollectorDTO {

    private Long studentID;

    private Long personID;

    private String collectedDate;

    private String collectedTime;


    public CollectorDTO() {
    }

    public CollectorDTO(String collectedDate, String collectedTime) {
        this.collectedDate = collectedDate;
        this.collectedTime = collectedTime;
    }

    public CollectorDTO(Collector collector) {
        this.collectedDate = collector.getCollectedDate();
        this.collectedTime = collector.getCollectedTime();
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
