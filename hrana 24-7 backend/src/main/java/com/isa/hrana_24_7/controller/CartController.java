package com.isa.hrana_24_7.controller;

import com.isa.hrana_24_7.model.NewCart;
import com.isa.hrana_24_7.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/cart")
    public int getTotal(@RequestBody NewCart[] cart, Model model){
        cartService.saveToCart(cart);
        return cartService.calculateTotal(cart);
    }

    @RequestMapping("/changeDB")
    public boolean changeDB(){
        cartService.updateDB();
        return true;
    }
    @PostMapping("/addToCart")
    public NewCart[] increaseQuantity(@RequestBody NewCart[] cart, Model model){
        cartService.addItems(cart);
        return cart;
    }
    @PostMapping("/addNewItem")
    public boolean addNewItem(@RequestParam("file") MultipartFile file, @RequestParam("newFoodItem") String newFoodData) throws IOException {
        return cartService.addNewItem(file,newFoodData);
    }
    @PostMapping("/addNewItemUrl")
    public boolean addNewItemByUrl(@RequestParam("newFoodItem") String newFoodData) throws IOException {
        return cartService.addNewItemWithUrl(newFoodData);
    }
    @PostMapping("/checkItemId")
    public boolean checkItemId(@RequestBody Long itemId, Model model){
        return !cartService.itemIdAvailable(itemId);
    }
}

