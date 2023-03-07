package com.example.springBootLearner_course_coustomQuery.repository;

import com.example.springBootLearner_course_coustomQuery.model.Course;
import com.example.springBootLearner_course_coustomQuery.model.Learner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // read all Course
    public List<Course> getAllCourse() {
        String getAllCourseQuery = "SELECT * FROM Course";
        return jdbcTemplate.query(getAllCourseQuery, new BeanPropertyRowMapper<Course>(Course.class));
    }

    //read Course by id
    public Course getCourseById(int id) {
        String getCourseByIdQuery = "SELECT * FROM Course WHERE ID =?";
        return jdbcTemplate.queryForObject(getCourseByIdQuery, new BeanPropertyRowMapper<Course>(Course.class), new Object[]{id});
    }

    //Insert  Course
    public int insertCourse(Course course) {
        String insertCourseQuery = "INSERT INTO COURSE VALUES( ?,?,?)";
        return jdbcTemplate.update(insertCourseQuery, new Object[]
                {
                        course.getId(),
                        course.getCourse_name(),
                        course.getCourse_description()


                });
    }
    //update Course

    public int updateCourse(Course course) {
        String updateCourseQuery = "UPDATE COURSE"+
                "SET ID=?,COURSE_NAME=?,COURSE_DESCRIPTION=?"+
                " WHERE ID=?";
        return jdbcTemplate.update(updateCourseQuery, new Object[]
                {
                        course.getId(),
                        course.getCourse_name(),
                        course.getCourse_description()

                });
    }

    //delete course
    public int deleteCourse(int id) {
        String deleteCourseQuery = "DELETE FROM COURSE WHERE ID=?";
        return jdbcTemplate.update(deleteCourseQuery, id);
    }
}
