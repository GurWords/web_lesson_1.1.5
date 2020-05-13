package configdb;


import model.User;
import com.mysql.jdbc.Driver;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.service.ServiceRegistry;
import util.readProperties;

public class DBHelper {
    private static DBHelper instance = null;

    private DBHelper() {
    }

    public static DBHelper getInstance() {
        if (instance == null) {
            instance = new DBHelper();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance());
            return DriverManager.getConnection(readProperties.getInstance().getConfigJDBCProperties().getProperty("url"));
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Configuration getConfiguration() {
        try {
            Configuration configuration = new Configuration();
            configuration.setProperties(readProperties.getInstance().getConfigHibrnateProperties());
            configuration.addAnnotatedClass(User.class);
            return configuration;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }
    public SessionFactory getSessionFactory() {
            Configuration configuration = DBHelper.getInstance().getConfiguration();
            configuration.addAnnotatedClass(User.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
            builder.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = builder.build();
            return configuration.buildSessionFactory(serviceRegistry);
    }
}

