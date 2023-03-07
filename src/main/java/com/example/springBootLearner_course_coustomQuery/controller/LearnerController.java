package com.example.springBootLearner_course_coustomQuery.controller;

import com.example.springBootLearner_course_coustomQuery.model.Learner;
import com.example.springBootLearner_course_coustomQuery.service.CourseService;
import com.example.springBootLearner_course_coustomQuery.service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/learners")
public class LearnerController {
    @Autowired
    private LearnerService learnerService;
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Learner> getAllLearner() {
        return learnerService.getAllLearner();

    }

    @GetMapping("/{id}")
    public Learner getLearnerById(@PathVariable int id) {
        return learnerService.getLarnerById(id);
    }

    @PostMapping
    public Learner addLearner(@RequestBody Learner learner) {
        return learnerService.addLearner(learner);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        learnerService.deleteByIdLearner(id);
    }

    @PostMapping("/findemail")
    public List<Learner> findByEmailAddressAndLastName(@RequestBody String email, String last_name) {

        return learnerService.findByEmailAddressAndLastName(email, last_name);

    }
    @PostMapping("/findbyfirstandlastname")
    public List<Learner> findByDistinctLearnerByFirstNameOrLastName(@RequestBody String first_name,String last_name)
    {
        return learnerService.findByDistinctLearnerByFirstNameOrLastName(first_name, last_name);
    }
    @PostMapping("/findlastfirstnameordrby")
    public List<Learner> findLastNameOrderByFirstNameASC(@RequestBody String  last_name)
    {
        return learnerService.findLastNameOrderByFirstNameASC(last_name);
    }
    @PutMapping("/{id}/course/{c_id}")
    public Learner assignCourseToLearner(@PathVariable("id")int id, @PathVariable("c_id") int c_id)
    {
        return learnerService.assignProfile(id,courseService.getCourseById(c_id));

    }
}
