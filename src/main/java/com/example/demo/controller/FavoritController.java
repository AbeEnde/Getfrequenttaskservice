package com.example.demo.controller;

import com.example.demo.model.Favorite;
import com.example.demo.repository.FavoriteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FavoritController {
    @Autowired
    FavoriteRepo favoriteRepo;

    int countCheak(){
        List<Favorite> list = favoriteRepo.findByUserID("ab1");
        return list.size();
    }

    @PostMapping("/addFav")
    public Favorite addFav(@RequestBody Favorite favorite){
        if (countCheak()<5){
            return favoriteRepo.save(favorite);

        }else{
            return null;
        }
    }

    @GetMapping("/getFav")
    public List<Favorite> getFavService(){
        //Long id = userRepository.findByName(authentication.getName()).getId();
        String userID = "ab1";
        return favoriteRepo.findByUserID(userID);
    }

    @DeleteMapping("/deleteSelected/{id}")
    public void deleteSelected (@PathVariable("id") Long id){
         favoriteRepo.deleteById(id);
    }

}
