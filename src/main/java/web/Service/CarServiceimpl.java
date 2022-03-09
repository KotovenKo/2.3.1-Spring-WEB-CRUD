package web.Service;

import org.springframework.stereotype.Component;
import web.DAO.CarDAO;
import web.DAO.CarDAOListimpl;
import web.model.Car;

import java.util.List;

@Component
public class CarServiceimpl implements CarService{

    CarDAO carDAO = new CarDAOListimpl();
    @Override
    public List<Car> getCars() {
        return carDAO.getCars();
    }

    @Override
    public void addCar(Car car) {
        carDAO.addCar(car);

    }

    @Override
    public List<Car> getNumberOfCars(int counter) {
        return carDAO.getNumberOfCars(counter);
    }
}
