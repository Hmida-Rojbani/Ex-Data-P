package de.tekup.ex.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.ex.data.models.Movie;
import de.tekup.ex.data.models.Studio;
import de.tekup.ex.services.CinemaService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CinemaRest {
	
	private CinemaService service;
	
	@GetMapping("/api/cinema/star/{starName}/studios")
	public List<Studio> getSudios(@PathVariable("starName") String starName){
		return service.getStudiosByStarName(starName);
	}
	@GetMapping("/api/cinema/studio/{studioName}/movies")
	public List<Movie> getColoredMovies(@PathVariable("studioName") String studioName){
		return service.getColoredMoviesByStudio(studioName);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

}
