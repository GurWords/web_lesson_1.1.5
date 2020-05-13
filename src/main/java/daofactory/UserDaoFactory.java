package daofactory;

import dao.interfacedao.UserDAO;
import dao.userdao.UserHibernateDAO;
import dao.userdao.UserJdbcDAO;

import java.util.Properties;

import util.readProperties;

public class UserDaoFactory {
    public static UserDaoFactory instance;

    private UserDaoFactory() {
    }

    public static UserDaoFactory getInstance() {
        if (instance == null) {
            instance = new UserDaoFactory();
        }
        return instance;
    }

    public UserDAO getUserDAO() {
        Properties properties = readProperties.getInstance().getUserDAOProperties();
        switch (properties.getProperty("daotype")) {
            case "UserJdbcDAO":
                return new UserJdbcDAO();
            case "UserHibernateDAO":
                return new UserHibernateDAO();
            default:
                return new UserHibernateDAO();
        }
    }
}
