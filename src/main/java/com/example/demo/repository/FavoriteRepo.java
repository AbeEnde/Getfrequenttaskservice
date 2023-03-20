package com.example.demo.repository;

import com.example.demo.model.Favorite;
import com.example.demo.utils.FavService;
import com.example.demo.utils.FrequentTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepo extends JpaRepository<Favorite,Long> {
    List<Favorite> findByUserID(String userID);

    @Query(value = "SELECT new com.example.demo.utils.FavService( s.id,s.name,f.userID) from Service s " +
            "INNER JOIN Favorite f ON f.serviceID = s.id WHERE f.userID = ?1"
    )
    List<FavService> getFavoriteServices(String userID);


}
