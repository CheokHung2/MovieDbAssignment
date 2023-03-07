package com.learningSpring.MovieApp;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class actorAdder {


    public static void addOrUpdateActor(Set<Actor> actors, Movie movie, ActorRepository actorRepository) {
        for (Actor actor : actors) {
            Boolean exists = actorRepository.existsByName(actor.getName());
            if (exists) {
                Actor existActor = actorRepository.findActorsByName(actor.getName());
                movie.addActor(existActor);
            } else {
                Actor newActor = new Actor();
                newActor.setName(actor.getName());
                movie.addActor(newActor);
            }
        }
    }
}
