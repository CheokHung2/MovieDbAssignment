package com.learningSpring.MovieApp;

public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException(Long id) {
        super("could not find movie with id: ");
    }
}
