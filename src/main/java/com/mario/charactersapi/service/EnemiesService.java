package com.mario.charactersapi.service;

import com.mario.charactersapi.model.Enemies;
import com.mario.charactersapi.repository.EnemiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnemiesService {

    private final EnemiesRepository enemiesRepository;

    public Page<Enemies> getAllEnemiesByNameContains(Integer pageNumber, Integer pageSize, String name)
    {
        if(pageNumber < 0 || pageSize < 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Request ..");
        return enemiesRepository.findAllByNameContains(name,
                PageRequest.of(pageNumber, pageSize).withSort(Sort.Direction.ASC, "name"));
    }

    public Enemies createEnemy(EnemiesRequest request) //from the public record
    {
        Enemies enemy = Enemies.builder()
                .name(request.name)
                .description(request.description)
                .picture(request.picture)
                .build();

        return enemiesRepository.save(enemy);
    }

    public Enemies getEnemyById(Long id)
    {
        return enemiesRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Object Not Found ..")
        );
    }

    public record EnemiesRequest(
            String name,
            String description,
            String picture
    ) {
    }

}
