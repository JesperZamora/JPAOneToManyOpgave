package com.example.jpaonetomanyopgave.repositories;

import com.example.jpaonetomanyopgave.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,String> {


    @Query("SELECT p FROM Region p WHERE p.navn LIKE CONCAT('%', :query, '%') or p.kode LIKE CONCAT('%', :query, '%')")
    List<Region> findRegionsByNameOrCode(String query);

    @Query("SELECT p.navn FROM Kommune p WHERE p.region.kode LIKE :query")
    List<String> findAllKommuneNamesByRegionCode(String query);
}
