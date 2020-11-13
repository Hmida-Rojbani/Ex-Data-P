package de.tekup.ex.services;

import java.util.List;

import de.tekup.ex.data.models.Movie;
import de.tekup.ex.data.models.Studio;

public interface CinemaService {
	public List<Studio> getStudiosByStarName(String name);
	public List<Movie> getColoredMoviesByStudio(String studioName);
	

}
