package com.yeahbutstill.springbootv3.dao;

import com.yeahbutstill.springbootv3.entity.UserHardcode;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<UserHardcode> usersUserHardcodes = new ArrayList<>();
    private static Integer userCount = 0;
    static {
        usersUserHardcodes.add(new UserHardcode(String.valueOf(++userCount), "Dani", "danilaway@yeahbutstill.com", LocalDate.now().minusYears(29)));
        usersUserHardcodes.add(new UserHardcode(String.valueOf(++userCount), "Maya", "maya@yeahbutstill.com", LocalDate.now().minusYears(28)));
        usersUserHardcodes.add(new UserHardcode(String.valueOf(++userCount), "Winda", "winda@yeahbutstill.com", LocalDate.now().minusYears(25)));
    }


    public List<UserHardcode> findAll() {
        return usersUserHardcodes;
    }

    public UserHardcode save(UserHardcode userHardcode) {
        userHardcode.setId(String.valueOf(++userCount));
        usersUserHardcodes.add(userHardcode);
        return userHardcode;
    }

    public UserHardcode findOne(String  id) {
        Predicate<? super UserHardcode> predicate = userHardcode -> userHardcode.getId().equals(id);
        return usersUserHardcodes.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deletById(String  id) {
        Predicate<? super UserHardcode> predicate = userHardcode -> userHardcode.getId().equals(id);
        usersUserHardcodes.removeIf(predicate);
    }

}
