package com.yeahbutstill.demo.commandliners;

import com.yeahbutstill.demo.dao.CourseJPADao;
import com.yeahbutstill.demo.entity.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
// kapan pun anda ingin mengeksekusi query dengan JPA
@Transactional
@Slf4j
public class CourseJPACommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJPADao courseJPADao;

    @Override
    public void run(String... args) throws Exception {
        courseJPADao.insert(new Course(4L, "Learn AWS EC2 JPA", "Maya"));
        courseJPADao.insert(new Course(5L, "Learn AZURE JPA", "Winda"));
        courseJPADao.insert(new Course(6L, "Learn DEVOPS JPA", "Sehu"));
        courseJPADao.insert(new Course(7L, "Learn PostgreSQL JPA", "Yuni"));
        courseJPADao.insert(new Course(8L, "Learn Docker JPA", "Dani"));
        courseJPADao.insert(new Course(9L, "Learn Kubernetes JPA", "Dani"));

        courseJPADao.deleteById(4L);

        log.info("Select By id => {}", courseJPADao.findById(5L));
        log.info("Select By id => {}", courseJPADao.findById(7L));
    }

}
