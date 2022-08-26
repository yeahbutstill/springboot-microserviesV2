package com.yeahbutstill.demo.commandliners;

import com.yeahbutstill.demo.dao.UserAjaSpringDataJPADao;
import com.yeahbutstill.demo.entity.UserAja;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CourseSpringDataJPACommandLineRunner implements CommandLineRunner {

    @Autowired
    private UserAjaSpringDataJPADao repository;

    @Override
    public void run(String... args) throws Exception {

        repository.save(new UserAja("10L", "Maya1", "maya1@yeahbutstill.com"));
        repository.save(new UserAja("11L", "Maya2", "maya2@yeahbutstill.com"));
        repository.save(new UserAja("12L", "Maya3", "maya3@yeahbutstill.com"));
        repository.save(new UserAja("13L", "Maya4", "maya4@yeahbutstill.com"));
        repository.save(new UserAja("14L", "Maya5", "maya5@yeahbutstill.com"));
        repository.save(new UserAja("15L", "Maya6", "maya6@yeahbutstill.com"));
        repository.save(new UserAja("16L", "Maya7", "maya7@yeahbutstill.com"));
        repository.save(new UserAja("17L", "Maya8", "maya8@yeahbutstill.com"));
        repository.save(new UserAja("18L", "Maya9", "maya9@yeahbutstill.com"));

        repository.deleteById("13L");

        log.info("Select By id => {}", repository.findById("11L"));
        log.info("Select By id => {}", repository.findById("14L"));

        log.info("Count Data in Table => {}", repository.count());

        log.info("{}", repository.findByEmail("maya9@yeahbutstill.com"));
        log.info("{}", repository.findByEmail(""));

    }

}
