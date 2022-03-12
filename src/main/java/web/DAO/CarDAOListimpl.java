package web.DAO;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDAOListimpl implements CarDAO {

    private int counterCars;
    private List<Car> cars;

    public CarDAOListimpl(){
        cars = new ArrayList<>();
        cars.add(new Car(++counterCars, "Mazda", "red", 150)) ;
        cars.add(new Car(++counterCars, "FORD", "white", 170));
        cars.add(new Car(++counterCars, "MERS", "yello", 250));
        cars.add(new Car(++counterCars, "MITSU", "purple", 80));
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
