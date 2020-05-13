package dao.userdao;

import configdb.DBHelper;
import dao.interfacedao.UserDAO;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class UserHibernateDAO implements UserDAO {

    private static SessionFactory sessionFactory = DBHelper.getInstance().getSessionFactory();


    public static Session getSession() {
        return sessionFactory.openSession();
    }

    @Override
    public User getUserByName(String name) {
        Session session = UserHibernateDAO.getSession();
        Transaction transaction = session.beginTransaction();
        Query<User> query = session.createQuery("FROM User where name=:name");
        query.setParameter("name",name);
        User user = query.uniqueResult();
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public void deleteUser(User user) {
        user.setId(getIdByName(user.getName()));
        Session session = UserHibernateDAO.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    @Override
    public List<User> selectAllUsers() {
        Session session = UserHibernateDAO.getSession();
        Transaction transaction = session.beginTransaction();
        List<User> userList = session.createQuery("FROM User").list();
        transaction.commit();
        session.close();
        return userList;
    }

    @Override
    public void updateUser(User newUser) {
        Session session = UserHibernateDAO.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update User set name=:name,age=:age where id=:id");
        query.setParameter("name", newUser.getName());
        query.setParameter("age", newUser.getAge());
        query.setParameter("id", newUser.getId());
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void insertUser(User user) {
        Session session = UserHibernateDAO.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public long getIdByName(String name) {
        Session session = UserHibernateDAO.getSession();
        Transaction transaction = session.beginTransaction();
        Query<User> query = session.createQuery("FROM User where name=:name");
        query.setParameter("name", name);
        Long id = query.uniqueResult().getId();
        transaction.commit();
        session.close();
        return id;
    }

    @Override
    public String getRoleByName(String name) {
        Session session = UserHibernateDAO.getSession();
        Transaction transaction = session.beginTransaction();
        Query<User> query = session.createQuery("FROM User where name=:name");
        query.setParameter("name", name);
        String role = query.uniqueResult().getRole();
        transaction.commit();
        session.close();
        return role;
    }
}
