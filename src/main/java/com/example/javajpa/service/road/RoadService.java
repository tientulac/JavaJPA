package com.example.javajpa.service.road;

import com.example.javajpa.entity.Road;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoadService {

    Road save(Road road);

    Road update(Road road);

    List<Road> findAll();

    boolean delete(int id);

    Road findById(int id);

    List<Road> search(Road road);
}
