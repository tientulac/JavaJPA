package com.example.javajpa.controller;

import com.example.javajpa.entity.Road;
import com.example.javajpa.service.road.RoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/roads") // router
public class RoadController {

    @Autowired
    RoadService roadService;

    @RequestMapping(method = RequestMethod.GET, path = "test")
    public String getList() {
        return "Hello world !";
    }

    @RequestMapping(method = RequestMethod.POST)
    public Road create(@RequestBody Road road) {
        roadService.save(road);
        return road;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Road update(@RequestBody Road updateRoad) {
        Road road = roadService.findById(updateRoad.getRoadID());
        if (road != null) {
            road.setRoadName(updateRoad.getRoadName());
            road.setDescription(updateRoad.getDescription());
            road.setStatus(updateRoad.getStatus());
            road.setCreatedAt(updateRoad.getCreatedAt());
            road.setDistrict(updateRoad.getDistrict());
            roadService.update(road);
        }
        return road;
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public boolean delete(@PathVariable int id) {
        return roadService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public HashMap<String, Object> getList(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("page", page);
        response.put("limit", limit);
        response.put("data", roadService.findAll());
        return response;
    }

    @RequestMapping(method = RequestMethod.POST, path = "search")
    public List<Road> search(@RequestBody Road road) {
        List<Road> listSearch = new ArrayList<>();
        listSearch = roadService.search(road);
        return listSearch;
    }
}
