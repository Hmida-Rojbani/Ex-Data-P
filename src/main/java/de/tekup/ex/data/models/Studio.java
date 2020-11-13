package de.tekup.ex.data.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "studios")
@Data
public class Studio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 50, unique = true, nullable = false)
	private String name;
	@Column(length = 70)
	private String address;
	
	@OneToMany(mappedBy = "studio")
	private List<Movie> movies;

}
