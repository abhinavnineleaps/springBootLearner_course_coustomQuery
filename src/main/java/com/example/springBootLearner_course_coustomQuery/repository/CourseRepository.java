package com.example.springBootLearner_course_coustomQuery.repository;

import com.example.springBootLearner_course_coustomQuery.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {


}
