package com.learningSpring.MovieApp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDatabase(MovieRepository repository, ActorRepository actorRepository){
        //Actors
        Actor actor1 = new Actor();
        actor1.setName("actor1");
        Actor actor2 = new Actor();
        actor2.setName("actor2");

        //Movies
        Movie movie1 = new Movie();
        movie1.addActor(actor1);
        movie1.setDescription("coolmovie");
        movie1.setDirector("mr2");
        movie1.setTitle("magic1");
        movie1.setRelease_Year(1000);

        Movie movie2 = new Movie();
        movie2.addActor(actor2);
        movie2.setDescription("coolmovie2");
        movie2.setDirector("mr2");
        movie2.setTitle("magic2");
        movie2.setRelease_Year(1003);

        return args -> {
            log.info("Preloading " + repository.save(movie1));
            log.info("Preloading " + repository.save(movie2));
;
        };
    }

}
