package org.morning.school.service;

import org.morning.school.model.Movie;
import org.morning.school.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository repository;

    public List<Movie> getMovies() {
        return repository.getMovies();
    }

    public Movie getMovie(String imdbId) {
        return repository.getMovie(imdbId);
    }
}
