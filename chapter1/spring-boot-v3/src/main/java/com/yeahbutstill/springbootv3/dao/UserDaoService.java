package com.yeahbutstill.springbootv3.dao;

import com.yeahbutstill.springbootv3.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static Integer userCount = 0;
    static {
        users.add(new User(String.valueOf(++userCount), "Dani", "danilaway@yeahbutstill.com", LocalDate.now().minusYears(29)));
        users.add(new User(String.valueOf(++userCount), "Maya", "maya@yeahbutstill.com", LocalDate.now().minusYears(28)));
        users.add(new User(String.valueOf(++userCount), "Winda", "winda@yeahbutstill.com", LocalDate.now().minusYears(25)));
    }


    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        user.setId(String.valueOf(++userCount));
        users.add(user);
        return user;
    }

    public User findOne(String  id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deletById(String  id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }

}
