package com.isa.hrana_24_7.controller;

import com.isa.hrana_24_7.dao.FoodDaoImpl;
import com.isa.hrana_24_7.model.Food;
import com.isa.hrana_24_7.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/menu")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @RequestMapping(value = "/menu")
    public List<Food> getMenu(Model model) {
        return foodService.getFoodList();
    }

}
/*
@RestController
@CrossOrigin
public class FoodController {

    @Autowired
    FoodDaoImpl foodDao;

    @RequestMapping(value = "/menu")
    public List<Food> getMenu(Model model) {
        List<Food> foodItems ;
        foodItems = foodDao.getFoodList();
        return foodItems;
    }
}
*/