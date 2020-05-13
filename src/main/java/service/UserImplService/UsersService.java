package service.UserImplService;

import daofactory.UserDaoFactory;
import dao.interfacedao.UserDAO;
import service.UserInterfaceService.InterfaceUsersService;
import model.User;

import java.util.List;


public class UsersService implements InterfaceUsersService {

    private static UsersService instance = null;
    private static final UserDAO userDAO = UserDaoFactory.getInstance().getUserDAO();


    private UsersService() {
    }

    public static UsersService getInstance() {
        if (instance == null) {
            instance = new UsersService();
        }
        return instance;
    }

    public void updateUser(User newUser) {
        userDAO.updateUser(newUser);
    }

    public List<User> selectAllUsers() {
        return userDAO.selectAllUsers();
    }

    public void insertUser(User user) {
        userDAO.insertUser(user);
    }

    @Override
    public User getUserByName(String name) {
        return userDAO.getUserByName(name);
    }

    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    public long getIdByName(String name) {
        return userDAO.getIdByName(name);
    }

    public String getRoleByName(String name) {
        return userDAO.getRoleByName(name);
    }
}
