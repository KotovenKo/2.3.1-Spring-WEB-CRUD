package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.Service.CarService;
import web.model.Car;

import javax.validation.Valid;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;



    @GetMapping("")
    public String lisOffCars(Model model){
        model.addAttribute("cars", carService.getCars());
        return "cars/listofcars";
    }
    @GetMapping("/carbycounter")
    public String carsByCounter(@RequestParam(value = "counter") int counter, Model model){
        model.addAttribute("cars", carService.getNumberOfCars(counter));
        return "cars/carbycounter";
    }
    @GetMapping("/new")
    public String createCarPage(Model model){
        model.addAttribute("cars", new Car());
        return "cars/new";

    }

    @PostMapping("")
    public String createCar(@Valid @ModelAttribute(value = "cars") Car car, BindingResult bindingResult){

        if(bindingResult.hasErrors()) {
            return "cars/new";
        } else {
            carService.addCar(car);
            return "redirect:/cars";
        }

    }

}
