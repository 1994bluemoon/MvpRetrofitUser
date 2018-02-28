package vinova.henry.com.mvpretrofituser.dao;

import java.util.List;

import vinova.henry.com.mvpretrofituser.models.User;

public interface IUserDao {
    User fetchUserById(String userName);
    List<User> fetchAllUsers();

    boolean addUser(User user);

    boolean addUsers(List<User> users);
    boolean deleteAllUsers();
}
