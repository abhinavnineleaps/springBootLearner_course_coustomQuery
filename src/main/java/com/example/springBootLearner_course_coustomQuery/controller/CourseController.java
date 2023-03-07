package com.example.springBootLearner_course_coustomQuery.controller;

import com.example.springBootLearner_course_coustomQuery.model.Course;
import com.example.springBootLearner_course_coustomQuery.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourse() {
        return courseService.getAllCourse();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id)
    {
        return courseService.getCourseById(id);

    }
    @PostMapping
    public Course addCourse(@RequestBody Course course)
    {
        return courseService.addCourse(course);
    }
    @DeleteMapping
    public void deleteCourseById(@PathVariable int id)
    {
        courseService.deleteById(id);
    }
}
