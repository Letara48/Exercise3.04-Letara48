package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    CarRepository CarRepository;

    @RequestMapping("/")
    public String listCars(Model model){
        model.addAttribute("cars", CarRepository.findAll());
        return "list";
    }
    @GetMapping("/add")
    public String CarForm(Model model){
        model.addAttribute("car", new Car());
        return "carform";
    }
    @PostMapping("/process")
    public String processForm(@Valid Car car,
        BindingResult result) {
        if (result.hasErrors()){
            return "carform";
        }
        CarRepository.save(car);
        return "redirect:/";
    }
    @RequestMapping("/detail/{id}")
    public String showCar(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("car", CarRepository.findById(id).get());
        return "show";
    }
    @RequestMapping("/update/{id}")
    public String updateCar(@PathVariable("id") long id, Model model){
        model.addAttribute("car", CarRepository.findById(id).get());
        return "Carform";
    }
    @RequestMapping("/delete/{id}")
    public String delCar(@PathVariable("id") long id){
        CarRepository.deleteById(id);
        return "redirect:/";
    }
}


