package com.example.springBootLearner_course_coustomQuery.service;

import com.example.springBootLearner_course_coustomQuery.model.Course;
import com.example.springBootLearner_course_coustomQuery.model.Learner;
import com.example.springBootLearner_course_coustomQuery.repository.LearnerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class LearnerService {
    @Autowired
    LearnerRepository learnerRepository;

    @Transactional
    public List<Learner> findByEmailAddressAndLastName(String email, String last_name) {
        return learnerRepository.findByEmailAddressAndLastName(email, last_name);

    }

    @Transactional
    public List<Learner> findByDistinctLearnerByFirstNameOrLastName(String first_name, String last_name) {
        return learnerRepository.findByDistinctLearnerByFirstNameOrLastName(first_name, last_name);

    }
    @Transactional
    public List<Learner> findLastNameOrderByFirstNameASC(String last_name)
    {
        return  learnerRepository.findLastNameOrderByFirstNameASC(last_name);
    }
    public List<Learner> getAllLearner()
    {
        return learnerRepository.findAll();
    }
    public Learner getLarnerById(@PathVariable int id)
    {
        Optional<Learner> learner=learnerRepository.findById(id);
        if(learner.isEmpty())
            throw  new RuntimeException("ID does not excit");
        return learner.get();
    }
    public Learner addLearner(Learner learner)
    {
        return learnerRepository.save(learner);
    }
    public void deleteByIdLearner(@PathVariable("id") int id)
    {
        Optional<Learner> learner=learnerRepository.findById(id);
        if(learner.isEmpty())
            throw  new RuntimeException("ID does not excit");
        learnerRepository.delete(learner.get());
    }
    public Learner assignProfile(int id, Course course)
    {
        Learner learner=learnerRepository.findById(id).get();
        learner.setCourse(course);
        return learnerRepository.save(learner);
    }
}
