package com.example.demo.controller;

import com.example.demo.model.Favorite;
import com.example.demo.service.FavoriteService;
import com.example.demo.utils.FavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class FavoritController {

    @Autowired
    private FavoriteService favoriteService;

    /*
    *to get user id already configured can use next line code
    *Long UserId = userRepository.findByName(authentication.getName()).getId();
   */

    @PostMapping("/addFav")
    public Favorite addFav(@RequestBody Favorite favorite){
      return favoriteService.save(favorite);
    }


    @GetMapping("/getFav")
    public List<FavService> getFavService() {
        String userID = "ab1";

        return favoriteService.findAll(userID);
    }



    @DeleteMapping("/deleteSelected/{id}")
    public void deleteSelected (@PathVariable("id") Long id){
         favoriteService.deleteById(id);
    }

}
