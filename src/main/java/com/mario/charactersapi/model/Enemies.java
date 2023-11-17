package com.mario.charactersapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.lang.annotation.Documented;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Enemies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String picture;
}
