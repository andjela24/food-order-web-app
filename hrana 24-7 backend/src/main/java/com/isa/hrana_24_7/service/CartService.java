package com.isa.hrana_24_7.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.hrana_24_7.model.Cart;
import com.isa.hrana_24_7.model.Food;
import com.isa.hrana_24_7.model.NewCart;
import com.isa.hrana_24_7.model.NewFood;
import com.isa.hrana_24_7.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private FoodService foodService;

    @Value("${fileStorage}")
    private String storagePath;

    public void saveToCart(NewCart[] newCarts){
        cartRepository.deleteAll();
        cartRepository.flush();
        Cart cart= new Cart( 1,0,0,0,0,0);
        cart.setQuantity1(newCarts[0].getQuantity());
        cart.setQuantity2(newCarts[1].getQuantity());
        cart.setQuantity3(newCarts[2].getQuantity());
        if(newCarts.length>3)
            cart.setQuantity4(newCarts[3].getQuantity());
        if(newCarts.length>4)
            cart.setQuantity5(newCarts[4].getQuantity());
        if(newCarts.length>5)
            cart.setQuantity6(newCarts[6].getQuantity());
        cartRepository.save(cart);
    }

    public void updateDB() {
        List<Cart> carts = cartRepository.findAll();
        Cart cart = carts.get(1);
        List<Food> foods = foodService.findAll();
        foods.get(0).setQuantity(foods.get(0).getQuantity()-cart.getQuantity1());
        foods.get(1).setQuantity(foods.get(1).getQuantity()-cart.getQuantity2());
        foods.get(2).setQuantity(foods.get(2).getQuantity()-cart.getQuantity3());
        if(foods.size()>3)
            foods.get(3).setQuantity(foods.get(3).getQuantity()-cart.getQuantity4());
        if(foods.size()>4)
            foods.get(4).setQuantity(foods.get(4).getQuantity()-cart.getQuantity5());
        if(foods.size()>5)
            foods.get(5).setQuantity(foods.get(5).getQuantity()-cart.getQuantity6());
        foodService.saveAll(foods);
    }

    public List<Cart> getAllCart(){
        return cartRepository.findAll();
    }
    public void addItems(NewCart[] cart) {
        List<Food> foods = foodService.findAll();
        for(int i=0;i<foods.size();i++){
            foods.get(i).setQuantity(foods.get(i).getQuantity()+cart[i].getQuantity());
        }
        foodService.saveAll(foods);
    }

    public boolean addNewItem(MultipartFile file, String newFoodData) throws IOException {
        NewFood newFood = new ObjectMapper().readValue(newFoodData,NewFood.class);
        if(!file.isEmpty())
            if(saveFileToAssets(file))
            {
                foodService.save(new Food(newFood.getId(),newFood.getName(),newFood.getPrice(),newFood.getQuantityAvailable(),"/assets/"+file.getOriginalFilename(),"",""));
//            foodDao.save(new Food(newFood.getId(),newFood.getName(),newFood.getPrice(),newFood.getQuantityAvailable(),"\\"+file.getOriginalFilename(),"",""));
            }
        return true;
    }

    public boolean addNewItemWithUrl(String newFoodData) throws IOException {
        NewFood newFood = new ObjectMapper().readValue(newFoodData,NewFood.class);
        foodService.save(new Food(newFood.getId(),newFood.getName(),newFood.getPrice(),newFood.getQuantityAvailable(),newFood.getFileDataF(),"",""));
        return true;
    }
    private boolean saveFileToAssets(MultipartFile file) throws IOException {
        Path filepath = Paths.get(storagePath, file.getOriginalFilename());
        file.transferTo(filepath);
        return true;
    }
    public int calculateTotal(NewCart[] newCart){
        int total=0;
        List<Food> foods = foodService.findAll();

        for(int i=0;i<foods.size();i++)
        {
            total+=foods.get(i).getPrice()*newCart[i].getQuantity();
        }
        return total;
    }
    public boolean itemIdAvailable(Long itemId) {
        return foodService.findById(itemId).isPresent();
    }
}

