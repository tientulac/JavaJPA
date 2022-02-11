package com.example.javajpa.repository;

import com.example.javajpa.entity.District;
import com.example.javajpa.entity.Road;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface RoadRepository extends JpaRepository<Road, Integer> {
      @Query("SELECT r FROM Road r WHERE r.RoadName LIKE %:roadName%")
      List<Road> searchRoadByName(String roadName);
}
