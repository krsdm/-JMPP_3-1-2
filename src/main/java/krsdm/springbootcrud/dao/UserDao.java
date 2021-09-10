package krsdm.springbootcrud.dao;


import krsdm.springbootcrud.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User getUserById(long id);
    void saveUser(User user);
    void updateUser(User updatedUser);
    void removeUser(long id);
    User getUserByName(String userName);
}
