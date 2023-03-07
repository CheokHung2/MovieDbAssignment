package com.learningSpring.MovieApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class MovieController {
    // referencing https://spring.io/guides/tutorials/rest/
    private final MovieRepository repository;
    private final ActorRepository actorRepository;
    @Autowired
    MovieController(MovieRepository repository, ActorRepository actorRepository){
        this.repository = repository;
        this.actorRepository = actorRepository;
    }
    // Requirements
    // Retrieve a list of movies.done
    // Retrieve information about a specific movie.done
    // Create a new movie.done
    // Update an existing movie. done
    // Delete a movie.done

    @GetMapping("/movies")
    // Retrieve a list of movies
    List<Movie> getAll(){
        return repository.findAll();
//    CollectionModel<EntityModel<Movie>> getAll(){
//        List<EntityModel<Movie>> movies = repository.findAll().stream().
//            map( movie -> assembler.toModel(movie))
//            .toList();
//        return CollectionModel.of(movies, linkTo(methodOn(MovieController.class).getAll()).withSelfRel());
    }

    @GetMapping("/movies/{id}")
    // Retrieve information about a specific movie.
    Optional<Movie> byId(@PathVariable Long id) throws MovieNotFoundException {
        return repository.findById(id);
//    EntityModel<Movie> byId(@PathVariable Long id) throws MovieNotFoundException {
//         Movie mov = repository.findById(id)
//                .orElseThrow(() -> new MovieNotFoundException(id));
//        return assembler.toModel(mov);

    }

    @PostMapping("/movies")
    // Create a new movie.
    Movie newMovie(@RequestBody Movie newMovie){
        Movie movie = new Movie();
        movie.setDescription(newMovie.getDescription());
        movie.setDirector(newMovie.getDirector());
        movie.setTitle(newMovie.getTitle());
        movie.setRelease_Year(newMovie.getRelease_Year());

        Set<Actor> actors = newMovie.getActors();
        actorAdder.addOrUpdateActor(actors, movie, actorRepository);
        return repository.save(movie);
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

    //TODO Filter by actor, Filter by director, authentication (done)

    @GetMapping("/movies/director/{director}")
    List<Movie> byDirector(@PathVariable String director){
        return repository.findByDirector(director);
    }

    @GetMapping("/movies/actors/{actor}")
    Set<Movie> hasActor(@PathVariable String actor){
        return actorRepository.findActorsByName(actor).getMovies();
    }


}
