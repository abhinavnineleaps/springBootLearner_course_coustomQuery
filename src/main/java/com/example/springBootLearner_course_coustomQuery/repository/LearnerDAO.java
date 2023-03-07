package com.example.springBootLearner_course_coustomQuery.repository;

import com.example.springBootLearner_course_coustomQuery.model.Learner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LearnerDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // read all learners
    public List<Learner> getAllLearner() {
        String getAllLearnerQuery = "SELECT * FROM Learner";
        return jdbcTemplate.query(getAllLearnerQuery, new BeanPropertyRowMapper<Learner>(Learner.class));
    }

    //read learner by id
    public Learner getLearnerById(int id) {
        String getLearnerByIdQuery = "SELECT * FROM Learner WHERE ID =?";
        return jdbcTemplate.queryForObject(getLearnerByIdQuery, new BeanPropertyRowMapper<Learner>(Learner.class), new Object[]{id});
    }

    //Insert  learners
    public int insertLearner(Learner learner) {
        String insertLearnerQuery = "INSERT INTO LEARNER VALUES( ?,?,?,?,?,?)";
        return jdbcTemplate.update(insertLearnerQuery, new Object[]
                {
                        learner.getId(),
                        learner.getCourse().getId(),
                        learner.getFirst_name(),
                        learner.getLast_name(),
                        learner.getEmail_id(),
                        learner.getPassword()
                });
    }
    //update learner

    public int updateLearner(Learner learner) {
        String updateLearnerQuery = "UPDATE LEARNER" +
                "SET COURSE_ID=?,FIRST_NAME=?,LAST_NAME=?,EMAIL=?,PASSWORD=?  " +
                "WHERE ID =?";
        return jdbcTemplate.update(updateLearnerQuery, new Object[]{
                learner.getId(),
                learner.getCourse().getId(),
                learner.getFirst_name(),
                learner.getLast_name(),
                learner.getEmail_id(),
                learner.getPassword()

        });
    }

    //delete learner
    public int deleteLearner(int id) {
        String deleteLearnerQuery = "DELETE FROM LEARNER WHERE ID=?";
        return jdbcTemplate.update(deleteLearnerQuery, id);
    }
}

