package com.learningSpring.MovieApp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Actor {

    @Id @GeneratedValue @Column(name = "id",unique = true)Long id;


    //TODO make many to many relation
    @Column(name = "name",unique = true)
    private String name;


    @ManyToMany(mappedBy = "Actors")
    private Set<Movie> movies  = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @JsonIgnore
    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
    public void addMovies(Movie movie){
        this.movies.add(movie);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(name, actor.name) && Objects.equals(movies, actor.movies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
//                ", movies=" + movies +
                '}';
    }
}
