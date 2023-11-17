package com.mario.charactersapi.repository;

import com.mario.charactersapi.model.Enemies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnemiesRepository extends JpaRepository<Enemies, Long> {

    Page<Enemies> findAllByNameContains(String name, Pageable pageable);


}
