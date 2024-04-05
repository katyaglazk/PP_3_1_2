package springcourse.springboot.PP_3_1_2.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import springcourse.springboot.PP_3_1_2.dao.UserDAO;
import springcourse.springboot.PP_3_1_2.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }

    @Override
    @Transactional
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Override
    @Transactional
    public User getById(Long id) {
        return userDAO.getOne(id);
    }
}
