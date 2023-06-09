package com.example.movie.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.movie.model.*;
import com.example.movie.service.*;

@RestController
public class MovieController{
    @Autowired
    MovieJpaService movieService;
    @GetMapping("/movies")
    public ArrayList<Movie> getMovies(){
        return movieService.getMovies();
    }
    @GetMapping("/movies/{movieId}")
    public Movie getMovie(@PathVariable("movieId") int movieId){
        return movieService.getMovie(movieId);
    }
    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }
    @PutMapping("/movies/{movieId}")
    public Movie updateMovie(@PathVariable("movieId") int movieId,@RequestBody Movie movie){
        return movieService.updateMovie(movieId, movie);
    }

    @DeleteMapping("/movies/{movieId}")
    public void DeleteMovie(@PathVariable("movieId")int movieId){
        movieService.deleteMovie(movieId);
    }

}