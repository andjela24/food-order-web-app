package com.isa.hrana_24_7.service;

import com.isa.hrana_24_7.model.Food;
import com.isa.hrana_24_7.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    public void saveAll(List<Food> foods) {
        foodRepository.saveAll(foods);
    }

    public Food save(Food food) {
        return foodRepository.save(food);
    }
//    public boolean isItemIdAvailable(Long itemId) {
//        return foodRepository.existsById(itemId);
//    }

    public Optional<Food> findById(Long itemId) {
        return foodRepository.findById(itemId);
    }
    public List<Food> getFoodList() {
        return foodRepository.findAll();
    }

    public Food validateFoodInfo(Long productId) {
        return foodRepository.findById(productId).orElse(null);
    }

}

