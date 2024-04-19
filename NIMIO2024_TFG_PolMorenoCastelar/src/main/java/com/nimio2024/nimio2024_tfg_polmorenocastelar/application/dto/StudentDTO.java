package com.nimio2024.nimio2024_tfg_polmorenocastelar.application.dto;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Course;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Student;

public class StudentDTO {

    private String studentName;
    private String studentSurname;
    private String studentDNI;

    private Course course;

    //TODO : Falta lista de Courses

    //TODO : Falta lista de Parents y Auth

    public StudentDTO(){

    }
    public StudentDTO(String student_name, String student_surname, String student_DNI, Course course) {
        this.studentName = student_name;
        this.studentSurname = student_surname;
        this.studentDNI = student_DNI;
        this.course = course;
    }

    public StudentDTO(Student student){
        this.studentName = student.getStudentName();
        this.studentSurname = student.getStudentSurname();
        this.studentDNI = student.getStudentDNI();
        this.course = student.getCourse();
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public String getStudentDNI() {
        return studentDNI;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public void setStudentDNI(String studentDNI) {
        this.studentDNI = studentDNI;
    }


    public Course getCourse() {
        return course;
    }
}
