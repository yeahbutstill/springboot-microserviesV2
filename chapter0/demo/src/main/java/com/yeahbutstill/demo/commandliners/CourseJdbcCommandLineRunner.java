package com.yeahbutstill.demo.commandliners;

import com.yeahbutstill.demo.dao.CourseDao;
import com.yeahbutstill.demo.entity.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseDao courseDao;

    @Override
    public void run(String... args) throws Exception {
        courseDao.insert(new Course(4L, "Learn AWS EC2", "Maya"));
        courseDao.insert(new Course(5L, "Learn AZURE", "Winda"));
        courseDao.insert(new Course(6L, "Learn DEVOPS", "Sehu"));
        courseDao.insert(new Course(7L, "Learn PostgreSQL", "Yuni"));

        courseDao.delete(4L);

        log.info("Select By id => {}", courseDao.findById(1L));
        log.info("Select By id => {}", courseDao.findById(6L));
    }

}
