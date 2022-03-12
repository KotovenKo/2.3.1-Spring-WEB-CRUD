package web.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.Service.CarService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class CarTester {

   Car car;
   @Autowired
   CarService carService;

   @PostConstruct
    public void crateNewCars(){
        carService.addCar(new Car("MAZDA", "red", 150)) ;
        carService.addCar(new Car( "FORD", "white", 170));
        carService.addCar(new Car( "MERS", "yello", 250));
        carService.addCar(new Car( "MITSU", "purple", 80));
    }

}
