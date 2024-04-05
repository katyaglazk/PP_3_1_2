package springcourse.springboot.PP_3_1_2.service;



import springcourse.springboot.PP_3_1_2.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();

    void add(User user);

    void update(User user);
    void delete(User user);
    User getById(Long id);
}
