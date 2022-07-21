/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import List.CampusList;

/**
 *
 * @author Admin
 */
public class Log {
    private Student student;
    private Course course;
    CampusList campusList;
    public Log() {
    }

    public Log(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public CampusList getCampusList() {
        return campusList;
    }

    public void setCampusList(CampusList campusList) {
        this.campusList = campusList;
    }
    
}
