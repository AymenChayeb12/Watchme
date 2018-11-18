/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.model.Movie;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author aymen
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class MovieService {

    @PersistenceContext
    private EntityManager em;
    
    
        public void updateOrSaveMovies(List<Movie> Movies) {
       
        for (Movie m : Movies) {
            if (m.getId() >= 1) {
                em.merge(m);
            } else {
                em.persist(m);
            }
        }
    }
        
        public void saveMovie(Movie movie){
            
            
            em.persist(movie);
            
        }

}
