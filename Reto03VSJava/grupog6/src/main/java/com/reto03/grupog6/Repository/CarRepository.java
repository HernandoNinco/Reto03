package com.reto03.grupog6.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto03.grupog6.CrudRepository.CarCrudRepository;
import com.reto03.grupog6.Entities.Car;

@Repository
public class CarRepository {
    @Autowired 

    private CarCrudRepository carRepository;
     public Car addCar(Car car){
        if (car.getIdCar() == null || car.getIdCar() == 0)
        return carRepository.save(car);
        else
        return car;
     }

    public List<Car> getall(){
        return (List<Car>) carRepository.findAll();
    }
    private Car existCar(Integer id) {
        Optional<Car> objCar = carRepository.findById(id);
        Car objCarRespuesta;

        if (objCar.isEmpty() == true)
            objCarRespuesta = null;
        else
            objCarRespuesta = objCar.get();
        
        return objCarRespuesta;

    }
    public Car updCar(Car car) {
        Car objCar;


        objCar = existCar(car.getIdCar());
        if (objCar == null)
            return car;
        else {
            if (car.getName() != null)
                objCar.setName(car.getName());

            if (car.getBrand() != null)
                objCar.setBrand(car.getBrand());

            if (car.getYear() != null)
                objCar.setYear(car.getYear());

            if (car.getDescription() != null)
                objCar.setDescription(car.getDescription());

          
            return carRepository.save(objCar);

        }
        
    }
    public void delCar(Integer id) {
        Car objCar;

        objCar = existCar(id);
        if (objCar != null)
            carRepository.deleteById(id);
    }

    public Car getCar(Integer id) {
        Car objCar;

        objCar = existCar(id);
        if (objCar != null)
            return objCar;
        else
            return null;
        
    }
}
