package ru.sstu.service;

import org.springframework.stereotype.Service;
import ru.sstu.entity.Gender;
import ru.sstu.entity.User;
import ru.sstu.repository.UserDAO;

import java.util.List;

/**
 * Created by user on 09.01.2017.
 */
@Service
public class UserService {

    private UserDAO userDAO;

    public List<User> getAllUsers()
    {
        return userDAO.listUsers();
    }

    public User getUserById(int id)
    {
        return userDAO.oneUser(id);
    }

    public List<User> getUserByGender(Gender gender)
    {
        return userDAO.listUsersWithGender(gender);
    }

    public User addUser(User user)
    {
        return userDAO.addUser(user);
    }
    public User deleteUser(int id)
    {
        return userDAO.deleteUser(id);
    }

    /**
     * @return the userDAO
     */
    public UserDAO getUserDAO() {
        return userDAO;
    }

    /**
     * @param userDAO the userDAO to set
     */
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

}