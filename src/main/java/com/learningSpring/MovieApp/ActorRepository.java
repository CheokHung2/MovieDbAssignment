package com.learningSpring.MovieApp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor,Long> {

    Actor findActorsByName(String name);

    Boolean existsByName(String name);
}
