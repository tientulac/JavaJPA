package com.example.javajpa.service.district;

import com.example.javajpa.entity.District;
import com.example.javajpa.repository.DistrictRepository;
import com.example.javajpa.repository.RoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    DistrictRepository districtRepository;

    @Override
    public List<District> findAll() {
        return districtRepository.findAll();
    }
}
