package com.example.javajpa.repository;

import com.example.javajpa.entity.District;
import com.example.javajpa.entity.Road;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepository extends JpaRepository<District, Integer> {
}
