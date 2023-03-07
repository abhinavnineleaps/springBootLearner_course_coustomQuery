package com.example.springBootLearner_course_coustomQuery.service;

import com.example.springBootLearner_course_coustomQuery.model.Course;
import com.example.springBootLearner_course_coustomQuery.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;
    public List<Course> getAllCourse()
    {
        return courseRepository.findAll();
    }
    public Course getCourseById(@PathVariable("id") int id)
    {
        Optional<Course> course=courseRepository.findById(id);
        if(course.isEmpty())
            throw new RuntimeException("ID DOES NOT EXSIT");
        return  course.get();
    }
    public Course addCourse(Course course)
    {
        return courseRepository.save(course);
    }
    public void deleteById(@PathVariable("id") int id)
    {
        Optional<Course> course=courseRepository.findById(id);
        if(course.isEmpty())
            throw new RuntimeException("course id does not excit");
        courseRepository.delete(course.get());

    }

}
