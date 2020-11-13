package de.tekup.ex.data.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "stars")
public class Star {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(length = 50, unique = true, nullable = false)
	private String name;
	@Column(length = 70)
	private String address;

	private Character gender;
	
	private LocalDate birthDate;
	
	@ManyToMany(mappedBy = "stars")
	private List<Movie> movies;

}
