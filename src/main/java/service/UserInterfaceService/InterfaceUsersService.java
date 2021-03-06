package service.UserInterfaceService;

import model.User;

import java.util.List;

public interface InterfaceUsersService {
    User getUserByName(String name);
    void deleteUser(User user);
    List<User> selectAllUsers();
    void updateUser(User newUser);
    void insertUser(User user);
    long getIdByName(String name);
    String getRoleByName(String name);
}