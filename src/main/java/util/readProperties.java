package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class readProperties {
    public static readProperties instance = null;

    private readProperties() {
    }

    public static readProperties getInstance() {
        if (instance == null) {
            return instance = new readProperties();
        }
        return instance;
    }

    public Properties getUserDAOProperties() {
        try {
            InputStream inputStream = readProperties.class.getClassLoader().getResourceAsStream("config.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException i) {
            i.getStackTrace();
        }
        return null;
    }

    public Properties getConfigHibrnateProperties() {
        try {
            InputStream is = readProperties.class.getClassLoader().getResourceAsStream("hibrnateconfig.properties");
            Properties properties = new Properties();
            properties.load(is);
            return properties;
        } catch (IOException i) {
            i.getStackTrace();
        }
        return null;
    }
    public Properties getConfigJDBCProperties() {
        try {
            InputStream is = readProperties.class.getClassLoader().getResourceAsStream("jdbcconfig.properties");
            Properties properties = new Properties();
            properties.load(is);
            return properties;
        } catch (IOException i) {
            i.getStackTrace();
        }
        return null;
    }
}
