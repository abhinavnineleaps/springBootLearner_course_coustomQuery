package com.example.springBootLearner_course_coustomQuery.controller;

import com.example.springBootLearner_course_coustomQuery.SpringBootLearnerCourseCoustomQueryApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.data.web.JsonPath;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@RunWith(SpringJUnit4ClassRunner.class)//For running this j unit 4
@ContextConfiguration(classes = SpringBootLearnerCourseCoustomQueryApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LearnerControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext learnerContext;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(learnerContext).build();
    }

    // converting real object to json object notation.
    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            System.out.println(jsonContent);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void verifyALlLearner() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/learners"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andDo(print());


    }

}
