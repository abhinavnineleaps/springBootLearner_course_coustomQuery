package com.example.springBootLearner_course_coustomQuery.repository;

import com.example.springBootLearner_course_coustomQuery.model.Learner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LearnerRepository extends JpaRepository<Learner, Integer> {
    @Modifying
    @Query("SELECT l FROM Learner l WHERE l.email_id= :email_id AND l.last_name= :last_name")
    List<Learner> findByEmailAddressAndLastName(@Param("email") String email, @Param("last_name") String last_name);

    @Modifying
    @Query("SELECT DISTINCT l FROM Learner l WHERE l.first_name= :first_name OR l.last_name= :last_name")
    List<Learner> findByDistinctLearnerByFirstNameOrLastName(@Param("first_name") String first_name, @Param("last_name") String last_name);

    @Modifying
    @Query("SELECT l FROM Learner l WHERE l.last_name= :last_name ORDER BY l.first_name ASC")
    List<Learner> findLastNameOrderByFirstNameASC(@Param("last_name") String last_name);


}
