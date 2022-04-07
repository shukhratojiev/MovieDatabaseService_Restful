package rest_PTZ5NI;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import struct.Movie;
import struct.MovieIdResult;
import struct.MovieList;



public class MovieDatabase implements IMovieDatabase {

	private static MovieList movieList;

	public MovieDatabase() {
		if (movieList == null) {
			movieList = new MovieList();
		}
	}
	
	@Override
	public MovieList getAllMovies() {
		return movieList;
	}

	@Override
	public Response getMovieById(int id) {
		Movie movie = movieList.getMovieById(id);
		if (movie == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(movie).build();
	}

	@Override
	public MovieIdResult insertMovie(Movie movie) {
		return movieList.addMovie(movie);
	}

	@Override
	public void updateOrInsertMovie(int id, Movie movie) {
		movie.setId(id);
		if (movieList.getMovieById(id) == null) {
			movieList.addMovie(movie);
		} else {
			movieList.modifyMovie(movie);
		}
	}

	@Override
	public void deleteMovie(int id) {
		if (movieList.getMovieById(id) != null) {
			movieList.removeMovieById(id);
		}
	}

	@Override
	public Response getMovieIds(int year, String field) {
		if (field.equals("Title") || field.equals("Director")) {
			return Response.ok(movieList.getMoviesByYear(year, field)).build();
		}
		return Response.status(Response.Status.BAD_REQUEST).build();
	}

}













