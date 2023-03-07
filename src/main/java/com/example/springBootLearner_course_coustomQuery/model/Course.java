package com.example.springBootLearner_course_coustomQuery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String course_name;
        private String course_description;

        public Course() {

        }
        public Course(int id, String course_name, String course_description) {
                this.id = id;
                this.course_name = course_name;
                this.course_description = course_description;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getCourse_name() {
                return course_name;
        }

        public void setCourse_name(String course_name) {
                this.course_name = course_name;
        }

        public String getCourse_description() {
                return course_description;
        }

        public void setCourse_description(String course_description) {
                this.course_description = course_description;
        }

        @Override
        public String toString() {
                return "Course{" +
                        "id=" + id +
                        ", course_name='" + course_name + '\'' +
                        ", course_description='" + course_description + '\'' +
                        '}';
        }
}
