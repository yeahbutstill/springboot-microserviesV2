package com.yeahbutstill.demo.dao;

import com.yeahbutstill.demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // hardcode
//    private static String INSERT_QUERY = """
//            INSERT INTO course (id, name, author) VALUES (4, 'Learn AWS1', 'Dani1');
//            INSERT INTO course (id, name, author) VALUES (5, 'Learn Docker2', 'Dani1');
//            INSERT INTO course (id, name, author) VALUES (6, 'Learn Kubernetes3', 'Dani1');
//            """;
    private static String INSERT_QUERY = """
            INSERT INTO course (id, name, author) VALUES (?, ?, ?);
            """;

    private static String DELETE_QUERY = """
            DELETE FROM course WHERE id = ?;
            """;

    private static String SELECT_QUERY = """
            SELECT * FROM course WHERE id = ?;
            """;

    public void insert(Course course) {
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void delete(Long id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(Long id) {
        // ResultSet -> Bean => Row Mapper => id
        return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }

}
