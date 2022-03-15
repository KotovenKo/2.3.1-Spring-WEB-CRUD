package web.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOHibernateEntityImpl implements UserDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        System.out.println("In the get user method");
        return entityManager.createQuery("select u from User u").getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getNumberOfUsers(int counter) {
        List<User> query = getUsers();
        if (counter > query.size()) {
            counter = query.size();
        }
        return query.subList(0, counter);
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(long id, User user) {
        System.out.println("In the update method");
        User updatedUser = getUser(id);
        updatedUser.setName(user.getName());
        updatedUser.setSecondName(user.getSecondName());
        updatedUser.setAge(user.getAge());
        updatedUser.setEmail(user.getEmail());
        entityManager.merge(updatedUser);
    }

    @Override
    public void delete(long id) {
        User user = getUser(id);
        entityManager.remove(user);
    }
}
