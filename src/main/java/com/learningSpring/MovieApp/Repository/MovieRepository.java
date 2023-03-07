package com.learningSpring.MovieApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {
    //done
    @Query(value = "Select * from movies m where :director =m.Director",nativeQuery = true)
    List<Movie> findByDirector(@Param("director") String director);
//
//    //don't know how to fix this
//    @Query(value = "select distinct m.id from movies m where (:actor) in m.actors",nativeQuery = true)
//    List<Movie> findByActor (@Param("actor") String actor);
}
