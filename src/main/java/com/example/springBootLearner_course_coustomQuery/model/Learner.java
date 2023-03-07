package com.example.springBootLearner_course_coustomQuery.model;

import jakarta.persistence.*;

import javax.naming.Name;

@Entity
public class Learner {
    @Id
    @GeneratedValue
    private int id;
    //Data cascading from one table to another
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id",referencedColumnName = "id")
    private Course course;
    private String first_name;
    private String last_name;
    private String email_id;
    private String password;

    public Learner() {

    }
    public Learner(int id,Course course, String first_name, String last_name, String email_id, String password) {
        this.id = id;
        this.course=course;

        this.first_name = first_name;
        this.last_name = last_name;
        this.email_id = email_id;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Learner{" +
                "id=" + id +
                ", course=" + course +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email_id='" + email_id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
