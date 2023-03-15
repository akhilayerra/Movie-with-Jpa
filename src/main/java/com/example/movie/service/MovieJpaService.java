package com.example.movie.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.movie.model.Movie;
import com.example.movie.repository.*;

@Service
public class MovieJpaService implements MovieRepository{
 @Autowired
    private MovieJpaRepository movierepository;

    @Override
    public ArrayList<Movie> getMovies(){
        List<Movie> movies1=movierepository.findAll();
        ArrayList<Movie> movies=new ArrayList<>(movies1);
        return movies;
    }

    @Override
    public Movie getMovie(int movieId){
        try{
        Movie movie= movierepository.findById(movieId).get();
        return movie;
        }catch (Exception e){

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }
    }
    @Override
    public Movie addMovie(Movie movieList){
        movierepository.save(movieList);
    return movieList;
    }
    @Override
    public Movie updateMovie(int movieId,Movie movieList){
      try{
      Movie newmovie=movierepository.findById(movieId).get();
        
        if(movieList.getMovieName()!=null){
            newmovie.setMovieName(movieList.getMovieName());
        }
        if(movieList.getLeadActor()!=null){
            newmovie.setLeadActor(movieList.getLeadActor());
        }
        movierepository.save(newmovie);
        return newmovie;
        }catch (Exception e){

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      } 
    }
    @Override
    public void deleteMovie(int movieId){
        try{
            movierepository.deleteById(movieId);
        }
        catch (Exception e){

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }  
    }
}