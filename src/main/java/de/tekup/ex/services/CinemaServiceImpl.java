package de.tekup.ex.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import de.tekup.ex.data.models.Movie;
import de.tekup.ex.data.models.Star;
import de.tekup.ex.data.models.Studio;
import de.tekup.ex.data.repositories.MovieRepository;
import de.tekup.ex.data.repositories.StarRepository;
import de.tekup.ex.data.repositories.StudioRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor // Dependency Injection Over Constructor
public class CinemaServiceImpl implements CinemaService{
	
	private MovieRepository reposMovie;
	private StarRepository reposStar;
	private StudioRepository reposStudio;
	
	

	@Override
	public List<Studio> getStudiosByStarName(String name) {
		// get Star
		Star star = reposStar.findByName(name)
				.orElseThrow(()-> new NoSuchElementException("Star not Found"));
		// what movies he played
		List<Movie> starMovies = star.getMovies();
		// extraction studios from movies
		return starMovies.stream()
						.map(movie -> movie.getStudio())
						.distinct()
						.collect(Collectors.toList());
	}



	@Override
	public List<Movie> getColoredMoviesByStudio(String studioName) {
		// get Studio
		Studio studio =  reposStudio.findByName(studioName)
				.orElseThrow(()-> new NoSuchElementException("Studio not Found"));
		
		return studio.getMovies().stream()
								 .filter(movie -> movie.getColor() == 1)
								 .collect(Collectors.toList());
	}

}
