package com.example.demo.repository;

import com.example.demo.model.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpinionRepository extends JpaRepository<Opinion,Long> {
    List<Opinion> findAllByOrderByTimeStamp();
}
