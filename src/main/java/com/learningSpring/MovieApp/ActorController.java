package com.learningSpring.MovieApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorController{

    private final ActorRepository actorRepository;

    public ActorController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }
    @GetMapping("/Actor")
        // Retrieve a list of movies
    List<Actor> getAll(){
        return  actorRepository.findAll();
    }

    @GetMapping("/Actor/{name}")
    Actor byName(@PathVariable String name){
        return actorRepository.findActorsByName(name);

    }
}
