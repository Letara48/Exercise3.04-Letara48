package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    CarRepository repository;

    @Override
    public void run(String... strings) throws Exception{
        Car car;
        car = new Car( "Honda", "Civic", 2009);
        repository.save(car);

        car = new Car( "Ford", "F-150", 2019);
        repository.save(car);

        car = new Car( "Porsche", "S-Class", 2015);
        repository.save(car);

    }
}
