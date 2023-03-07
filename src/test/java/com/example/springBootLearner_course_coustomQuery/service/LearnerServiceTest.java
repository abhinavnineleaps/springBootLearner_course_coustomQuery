package com.example.springBootLearner_course_coustomQuery.service;

import com.example.springBootLearner_course_coustomQuery.model.Course;
import com.example.springBootLearner_course_coustomQuery.model.Learner;
import com.example.springBootLearner_course_coustomQuery.repository.LearnerDAO;
import com.example.springBootLearner_course_coustomQuery.repository.LearnerRepository;
import org.bson.types.ObjectId;
import org.h2.command.dml.MergeUsing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LearnerServiceTest {
    // we are mocking repo. based data
    @Mock
    private LearnerRepository learnerRepository;
    //AFter mocking the mock data will send to a mock service
    @InjectMocks
    private LearnerService learnerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);


    }

    @Test
    public void getAllLearner() {
        //ADD values to the array list
        List<Learner> learnerList = new ArrayList<Learner>();
        learnerList.add(new Learner(1, new Course(2, "math", "calculation"), "Abhinav", "singh", "abc@gmail.com", "abhiav123password"));
        learnerList.add(new Learner(2, new Course(1, "phy", "calculation"), "Abhinav", "singh", "abc@gmail.com", "abhiav123password"));
       //After adding values we are saying the result will be carry out and stored in this learner list and this stored data act as a database for me
       // Learner Repository check
        Mockito.when(learnerRepository.findAll()).thenReturn(learnerList);
        // Learner Service Check
        List<Learner> learnerResult=learnerService.getAllLearner();
        // Actual Data check with expected result to the actual result
        assertEquals(2,learnerResult.size());//

    }
}
