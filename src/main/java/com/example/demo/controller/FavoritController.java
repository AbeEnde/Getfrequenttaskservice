package com.example.demo.controller;

import com.example.demo.utils.FrequentService;
import com.example.demo.model.Favorite;
import com.example.demo.repository.FavoriteRepo;
import com.example.demo.repository.ServiceTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class FavoritController {
    @Autowired
    FavoriteRepo favoriteRepo;

    @Autowired
    ServiceTaskRepository serviceTaskRepository;

    int countCheak() {
        List<Favorite> list = favoriteRepo.findByUserID("ab1");

        return list.size();
    }

    /*
    *to get user id already configured can use next line code
    *Long Userid = userRepository.findByName(authentication.getName()).getId();
   */

    @PostMapping("/addFav")
    public Favorite addFav(@RequestBody Favorite favorite){
        if (countCheak()<5){
            return favoriteRepo.save(favorite);
        }

        return null;
    }


    @GetMapping("/getFav")
    public List<Favorite> getFavService() {
        String userID = "ab1";

        return favoriteRepo.findByUserID(userID);
    }


    @GetMapping("/getFrequent")
    public List<FrequentService> getFrequent(){

        return serviceTaskRepository.getFrequent();
    }

    @DeleteMapping("/deleteSelected/{id}")
    public void deleteSelected (@PathVariable("id") Long id){
         favoriteRepo.deleteById(id);
    }

}
