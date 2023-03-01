package com.learningSpring.MovieApp;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class MovieController {
    // referencing https://spring.io/guides/tutorials/rest/
    private final MovieRepository repository;
    private final MovieModelAssembler assembler;

    MovieController(MovieRepository repository, MovieModelAssembler assembler){
        this.assembler = assembler;
        this.repository = repository;
    }
    // Requirements
    // Retrieve a list of movies.done
    // Retrieve information about a specific movie.done
    // Create a new movie.done
    // Update an existing movie. done
    // Delete a movie.done

    @GetMapping("/movies")
    // Retrieve a list of movies
    CollectionModel<EntityModel<Movie>> getAll(){
        List<EntityModel<Movie>> movies = repository.findAll().stream().
            map( movie -> assembler.toModel(movie))
            .toList();
        return CollectionModel.of(movies, linkTo(methodOn(MovieController.class).getAll()).withSelfRel());
    }

    @GetMapping("/movies/{id}")
    // Retrieve information about a specific movie.
    EntityModel<Movie> byId(@PathVariable Long id) throws MovieNotFoundException {
         Movie mov = repository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
        return assembler.toModel(mov);
    }

    @PostMapping("/movies")
    // Create a new movie.
    Movie newMovie(@RequestBody Movie newMovie){

        return repository.save(newMovie);
    }
    @PutMapping("/movies/{id}")
    // Update an existing movie.
    Movie updateMove(@RequestBody Movie newMovie, @PathVariable Long id){
        return repository.findById(id).
                map(movie ->{
                    movie.setTitle(newMovie.getTitle());
                    movie.setDescription(newMovie.getDescription());
                    movie.setDirector(newMovie.getDirector());
                    movie.setActors(newMovie.getActors());
                    movie.setRelease_Year(newMovie.getRelease_Year());
                    return repository.save(movie);
                }).
                orElseGet(
                ()-> {
                    newMovie.setId(id);
                    return repository.save(newMovie);
                    }
                );
    }

    @DeleteMapping("/movies/{id}")
    // Delete a movie.
    void deleteMovie (@PathVariable Long id){
        repository.deleteById(id);
    }


}
