package com.example.demo.service;

import com.example.demo.model.Favorite;
import com.example.demo.repository.FavoriteRepo;
import com.example.demo.utils.FavService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FavoriteService {

    @Autowired
   private  FavoriteRepo favoriteRepo;

    int countCheak() {
        List<Favorite> list = favoriteRepo.findByUserID("ab1");

        return list.size();
    }
    public Favorite save(Favorite favorite){

        if (countCheak()<5){
            return favoriteRepo.save(favorite);
        }

        return null;
    }

    public List<FavService> findAll(String UserId){

        return favoriteRepo.getFavoriteServices(UserId);
    }

    public void deleteById(Long id){
         favoriteRepo.deleteById(id);
    }
}
