package com.example.javajpa.service.road;

import com.example.javajpa.entity.Road;
import com.example.javajpa.repository.RoadRepository;
import com.example.javajpa.service.road.RoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoadServiceImpl implements RoadService {

    @Autowired
    RoadRepository roadRepository;

    @Override
    public Road save(Road road) {
        return roadRepository.save(road);
    }

    @Override
    public Road update(Road road) {
        return roadRepository.save(road);
    }

    @Override
    public List<Road> findAll() {
        return roadRepository.findAll();
    }

    @Override
    public boolean delete(int id) {
        Road road = roadRepository.findById(id).get();
        if (road != null) {
            roadRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Road findById(int id) {
        return roadRepository.findById(id).get();
    }

    @Override
    public List<Road> searchByName(String roadName) {
        List<Road> listSearch = new ArrayList<>();
//        return roadRepository.searchRoad(road.getRoadName(), road.getDistrict().getDistrictID());
        listSearch = roadRepository.searchRoadByName(roadName);
        return  listSearch;
    }

    @Override
    public List<Road> searchByDistrictID(int districtID) {
        List<Road> listSearch = new ArrayList<>();
        for (Road road : roadRepository.findAll())
        {
            if (road.getDistrict().getDistrictID() == districtID)
            {
                listSearch.add(road);
            }
        }
        return  listSearch;
    }
}
