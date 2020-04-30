package edu.food.model.controller;

import edu.food.model.repo.FoodTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    FoodTypeRepository repo;

    @RequestMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("foodTypes", repo.findAll());
        return "index";
    }

    @RequestMapping("/jql/{name}")
    public String getMainPageJql(Model model, @PathVariable("name") String name) {
        model.addAttribute("foodTypes", repo.getByName(name));
        return "index";
    }

}
