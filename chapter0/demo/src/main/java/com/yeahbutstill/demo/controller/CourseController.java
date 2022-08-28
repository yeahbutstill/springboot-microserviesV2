package com.yeahbutstill.demo.controller;

import com.yeahbutstill.demo.entity.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    // http://localhost:8080/course
    /***
     * [
     *   {
     *     "id": 1,
     *     "name": "Learn Microservices",
     *     "author": "Dani"
     *   },
     *   {
     *     "id": 2,
     *     "name": "Learn Microservices1",
     *     "author": "Maya"
     *   }
     * ]
     */
    @GetMapping("/course")
    public List<Course> courseList() {
        return List.of(
                new Course(1L, "Learn Microservices", "Dani"),
                new Course(2L, "Learn Microservices1", "Maya")
        );
    }

    // http://localhost:8080/course/1
    @GetMapping("/course/2")
    public Course courseDetails() {
        return new Course(2L, "Lalalalal2", "Yeyeyeyey2");
    }

}
