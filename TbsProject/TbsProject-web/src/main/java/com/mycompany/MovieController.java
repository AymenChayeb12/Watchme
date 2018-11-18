/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.model.Movie;
import com.mycompany.service.MovieService;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author aymen
 */

@ManagedBean
public class MovieController {
    
    
    public Model model = new Model();
    
 
    @EJB
    MovieService service;
    
    public void addnewMovie() {
       
        service.saveMovie(getModel().getMovie());
        getModel().getMovieList().add(getModel().getMovie());
        service.updateOrSaveMovies(getModel().getMovieList());
        getModel().setMovie(new Movie());

    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
         
    
    
    
    
    
    public static class Model{
        
        public List<Movie> movieList;
        public Movie movie;

        public Movie getMovie() {
            return movie;
        }

        public void setMovie(Movie movie) {
            this.movie = movie;
        }
        
         

        public List<Movie> getMovieList() {
            return movieList;
        }

        public void setMovieList(List<Movie> movieList) {
            this.movieList = movieList;
        }

      
        
        
        
        
    }
    
}
