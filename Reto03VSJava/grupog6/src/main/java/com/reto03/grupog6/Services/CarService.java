package com.reto03.grupog6.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto03.grupog6.Entities.Car;
import com.reto03.grupog6.Repository.CarRepository;



@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    public Car addCar(Car car){
        Boolean bGrabar = true;

        if (car.getName() == null)
            bGrabar = false;

        if (car.getDescription() == null)
            bGrabar = false;

        if (car.getBrand() == null)
            bGrabar = false;

        if (car.getYear() == null)
            bGrabar = false;


        if (bGrabar == true)
            return carRepository.addCar(car);
        else
            return car;
     }

    public List<Car> getall(){
        return (List<Car>) carRepository.getall();
    }  
    public Car updCar(Car car) {
        return carRepository.updCar(car);
    }
    public Car getCar(Integer id) {
        return carRepository.getCar(id);
    }
    public void delCar(Integer id) {
        carRepository.delCar(id);
    }
}
