package web.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Car;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CarDAOHibernateImpl implements CarDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Car> getCars() {
        TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car ");
        return query.getResultList();
    }

    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public List<Car> getNumberOfCars(int counter) {
        List<Car> query=sessionFactory.getCurrentSession().createQuery("from Car ").getResultList();
        if (counter > query.size()) {
            counter = query.size();
        }
        return query.subList(0,counter);
    }


}
