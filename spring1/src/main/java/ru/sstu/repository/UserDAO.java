package ru.sstu.repository;

import org.springframework.stereotype.Repository;
import ru.sstu.entity.Gender;
import ru.sstu.entity.User;
import ru.sstu.service.RandomValuesService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by user on 09.01.2017.
 */
@Repository
public class UserDAO {

    private RandomValuesService randomValuesService;

    private int initUsersCount = 0;

    private List<User> users;

    public void initUsers() {
        //Random r = new Random();
        users = new ArrayList<>();
        for (int i = 0; i < initUsersCount; i++) {
            User newUser = new User(
                    i + 1,
                    randomValuesService.randomString(6),
                    randomValuesService.randomString(8),
                    Gender.fromString(
                            randomValuesService.randomFromList(Arrays.asList("m", "f", "u"))
                    )
            );
            users.add(newUser);
        }
    }

    public List<User> listUsers() {
        if (!usersInited()) {
            initUsers();
        }
        return users;
    }

    public List<User> listUsersFiltered(Predicate<User> p) {
        if (!usersInited()) {
            initUsers();
        }
        User[] filteredArr = (User[]) users.
                stream().
                filter(p).
                toArray();
        List<User> filteredList = new ArrayList<>();
        for(User u : filteredArr)
        {
            filteredList.add(u);
        }

        return filteredList;
    }

    public List<User> listUsersWithGender(final Gender g) {
        if (!usersInited()) {
            initUsers();
        }

        return listUsersFiltered(
                new Predicate<User>() {
                    public boolean test(User u) {
                        return u.getGender().equals(g);
                    }
                }
        );
    }

    public User oneUser(int id) {
        User user = null;
        if (!usersInited()) {
            initUsers();
        }
        for (User u : users) {
            if (u.getId() == id) {
                user = u;
                break;
            }
        }
        return user;
    }

    public User addUser(User newUser) {
        if (!usersInited()) {
            initUsers();
        }
        users.add(newUser);
        newUser.setId(users.size() + 1);
        return newUser;
    }

    public User deleteUser(int id) {
        if (!usersInited()) {
            initUsers();
        }
        User deleted = null;
        for (User u : users) {
            if (u.getId() == id) {
                users.remove(u);
                deleted = u;
                break;
            }
        }
        return deleted;
    }

    public boolean usersInited() {
        if (users == null) {
            return false;
        } else {
            return !users.isEmpty();
        }
    }

    /**
     * @return the initUsersCount
     */
    public int getInitUsersCount() {
        return initUsersCount;
    }

    /**
     * @param initUsersCount the initUsersCount to set
     */
    public void setInitUsersCount(int initUsersCount) {
        this.initUsersCount = initUsersCount;
    }

    /**
     * @return the randomValuesService
     */
    public RandomValuesService getRandomValuesService() {
        return randomValuesService;
    }

    /**
     * @param randomValuesService the randomValuesService to set
     */
    public void setRandomValuesService(RandomValuesService randomValuesService) {
        this.randomValuesService = randomValuesService;
    }

}