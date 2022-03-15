package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import web.DAO.UserDAO;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceimpl implements UserService {

    @Qualifier("userDAOHibernateEntityImpl")
    @Autowired
    UserDAO userDAO;

    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public List<User> getNumberOfUsers(int counter) {
        return userDAO.getNumberOfUsers(counter);
    }

    @Override
    public User getUser(long id) {
        return userDAO.getUser(id);
    }

    @Override
    public void update(long id, User user) {
        userDAO.update(id, user);
    }

    public void delete(long id) {
        userDAO.delete(id);
    }
}
