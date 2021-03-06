package org.morning.school.repository;

import org.morning.school.model.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieRepository {

    @Value("${movies.csv.file}")
    private Resource moviesCsvFile;

    private List<Movie> movies;

    @PostConstruct
    private void loadMovies() throws URISyntaxException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(moviesCsvFile.getInputStream()));
        movies = reader.lines()
                .skip(1)
                .map(line -> new Movie(line))
                .collect(Collectors.toList());
    }

    public List<Movie> getMovies() {
        return new ArrayList<>(movies);
    }


    public Movie getMovie(String imdbId) {
        return movies.stream()
                .filter(m -> m.getImdbID().equals(imdbId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("imdbId %s not found.", imdbId)));
    }
}
