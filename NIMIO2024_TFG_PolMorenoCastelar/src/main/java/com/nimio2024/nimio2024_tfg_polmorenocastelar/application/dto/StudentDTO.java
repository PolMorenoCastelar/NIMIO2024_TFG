package com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto;

public class StudentDTO {

    private String student_name;
    private String student_surname;
    private String student_DNI;

    //TODO : Falta lista de Courses

    //TODO : Falta lista de Parents y Auth

    public StudentDTO(){

    }
    public StudentDTO(String student_name, String student_surname, String student_DNI) {
        this.student_name = student_name;
        this.student_surname = student_surname;
        this.student_DNI = student_DNI;
    }
}
