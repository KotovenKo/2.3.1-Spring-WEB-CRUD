package web.Service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.List;


public interface CarService {

    List<Car> getCars();

    void addCar(Car car);

    List<Car> getNumberOfCars(int counter);
}
