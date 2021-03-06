package com.example.kevin.gradecalculator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 11/7/2015.
 * Data for semester will be stored in text files for each semester using their term and year as
 * the unique file name
 */
public class Semester implements Serializable{
    //instance variables
    //year stores the year of that semester
    //term stores the term (Fall/Winter/Summer)
    //courses stores the list of courses for that term (ids and names)
    private int year;
    private String term;
    private List<Course> courses;

    //Constructor
    public Semester(String term, int year){
        this.term = term;
        this.year = year;
        this.courses = new ArrayList<>();
    }

    //Getters
    public String getTerm(){
        return term;
    }
    public int getYear(){
        return year;
    }
    public List<Course> getCourses(){
        return courses;
    }

    //Adders
    public void addCourse(Course course){
        courses.add(course);
    }

    //Deleters
    public void removeCourse(Course course){
        int counter = 0;
        for(Course currCourse : courses){
            if(currCourse.getName().equals(course.getName())){
                courses.remove(counter);
                break;
            }
            counter++;
        }
    }

    @Override
    public String toString(){
        String semester = year + " " + term;
        for(Course course: courses) {
            semester = semester + " " + course.getId();
        }
        semester = semester + "\n";
        return semester;
    }
}
