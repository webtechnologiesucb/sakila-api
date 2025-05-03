package com.ucb.sakila.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "film")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "film_id") 
	private Long id;

    private String title;
    private String description;
    
    @Column(name = "release_year") 
    private int releaseYear;
}