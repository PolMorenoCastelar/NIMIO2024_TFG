# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/).

## [Unreleased]

## [0.0.1] - 2023-03-05

### Fixed

### Added

- [NPP-1] 》Create Spring Project 
- [NPP-3] 》Architecture configuration & First Classes Testing

### Center 

- [NPP-9] 》CE1F - Create a Center and edit its Name
- [NPP-10] 》CE2F - Obtain the list of schools of a center
- [NPP-11] 》CE3F - Get all centers registered in the system
- [NPP-12] 》CE4F - Edit a Center by ID
- [NPP-13] 》CE5F - Delete a Center by ID

    ## Center Exceptions
    
    - [NPP-61] 》Center Exceptions - Create all center exceptions


### School

- [NPP-14] 》SC6F - Create a school that belongs to a center
- [NPP-15] 》SC7F - Get school by ID
- [NPP-16] 》SC8F - Get all courses of a school by ID
- [NPP-17] 》SC9F - Edit a school by ID (entire data)
- [NPP-18] 》SC10F - Delete a school by ID

    ## School Exceptions

    - [NPP-63] 》School Exceptions - Create all school exceptions
    
    ## School Extra Functionalities

    - [NPP-56] 》EX47 - Get center name from school by schoolID
    - [NPP-57] 》EX48 - Update only school name by schoolID
     

### Course

- [NPP-19] 》CO11F - Create a course that belongs to a school
- [NPP-20] 》CO12F - Edit a course name by courseID
- [NPP-21] 》CO13F - Add a student to a course with only id's
- [NPP-23] 》CO15F - Get all students and course details by courseID
- [NPP-22] 》CO14F - Add a student list and repeated students control by DNI
- [NPP-24] 》CO16F - Get only students of a course by courseID
- [NPP-25] 》CO17F - Delete a course by courseID without deleting students

    ## Course Exceptions
    
    - [NPP-62] 》Course Exceptions - Create all course exceptions

### Teacher

- [NPP-26] 》TE18F - Create a teacher  
- [NPP-27] 》TE19F - Update a teacher by ID
- [NPP-28] 》TE20F - Substitute a teacher by ID or Insert a new one
- [NPP-29] 》TE21F - Get all courses from a teacher by teacher ID
- [NPP-30] 》TE22F - Delete a teacher by ID
- [NPP-28] 》TE20F - Substitute a teacher by ID, with a teacher already created

    ## Teacher Exceptions

    - [NPP-65] 》Teacher Exceptions - Create all teacher exceptions

    ## Teacher Extra Functionalities

    - [NPP-60] 》EX51 - Get all teachers from school by schoolID

### Student

- [NPP-44] 》ST38F - Create a student associated with a course
- [NPP-55] 》ST46F - Create a student without associated course
- [NPP-45] 》ST39F - Update student by ID
- [NPP-47] 》ST41F - Delete Auth without deleting the person
- [NPP-48] 》ST42F - Get students by courseId
- [NPP-49] 》ST43F - Get student by ID
- [NPP-54] 》ST48F - Delete a student by ID

    ## Student Exceptions

    - [NPP-64] 》Student Exceptions - Create all student exceptions
    - 

    ## Student Extra Functionalities

    - [NPP-58] 》EX49 - Add students to a course by DNI and courseID
    - [NPP-59] 》EX50 - Migrate only students from a course to another course by coursesIDS


### ClassS

- [NPP-32] 》CL24F - Create classes 
- [NPP-33] 》CL25F - Get class by classID

### Schedule

- [NPP-31] 》SC23F - Get schedule by classId

    ## Schedule Extra Functionalities
    
    - [NPP-68] 》EX54F - Get all schedules for a course by courseID
    - [NPP-67] 》EX53F - Get all schedules for a class by classID

### Person

- [NPP-38] 》PE40F - Create Person

### Collector

- [NPP-46] 》ST40F - Create a collector instance by student and person and add authorized people to student 

