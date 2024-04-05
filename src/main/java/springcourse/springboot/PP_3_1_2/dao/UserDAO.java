package springcourse.springboot.PP_3_1_2.dao;


import springcourse.springboot.PP_3_1_2.model.User;

import java.util.List;

public interface UserDAO {
    void add(User user);
    void update(User user);
    void delete(User user);
    List<User> getAllUser();
    User getOne(Long id);

}
