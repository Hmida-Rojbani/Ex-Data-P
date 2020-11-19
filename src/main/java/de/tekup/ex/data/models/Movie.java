package de.tekup.ex.data.models;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "movies")
@Data
@Builder
@AllArgsConstructor
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	
	private Integer year;
	
	private LocalTime length;
	
	private Byte color;
	
	@ManyToOne
	@JoinColumn(name = "studio")
	private Studio studio;
	
	@ManyToMany
	@JoinTable(name = "stars_in" ,
	joinColumns = @JoinColumn(name = "movie"),
	inverseJoinColumns = @JoinColumn(name = "star"))
	private List<Star> stars;

}
