package com.example.jpaonetomanyopgave.repositories;

import com.example.jpaonetomanyopgave.model.Kommune;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KommuneRepository extends JpaRepository<Kommune,String> {
}
