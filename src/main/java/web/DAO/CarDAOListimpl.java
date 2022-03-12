package web.DAO;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDAOListimpl {

    private int counterCars;
    private List<Car> cars;

    public CarDAOListimpl(){
        cars = new ArrayList<>();
        cars.add(new Car(++counterCars, "Mazda", "red")) ;
        cars.add(new Car(++counterCars, "FORD", "white"));
        cars.add(new Car(++counterCars, "MERS", "yello"));
        cars.add(new Car(++counterCars, "MITSU", "purple"));
    }
   // @Override
    public List<Car> getCars() {
        return cars;
    }

   // @Override
    public void addCar(Car car) {
        cars.add(car);
    }

   // @Override
    public List<Car> getNumberOfCars(int counter) {
        if (counter > cars.size()) {
            counter = cars.size();
        }
        return cars.subList(0, counter);
    }
}
