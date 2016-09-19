package org.morning.school.controller;

import org.morning.school.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MovieController {

    @Autowired
    public MovieService service;

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public String getMovies(Model model) {
        model.addAttribute("movies",service.getMovies());
        return "listMovies";
    }

    @RequestMapping(value = "/movies/{imdbId}", method = RequestMethod.GET)
    public String getMovies(Model model, @PathVariable String imdbId) {
        model.addAttribute("movie",service.getMovie(imdbId));
        return "movie";
    }

}
