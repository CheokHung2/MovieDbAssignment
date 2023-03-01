package com.learningSpring.MovieApp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDatabase(MovieRepository repository){
        Movie test = new Movie();
        test.setActors(new ArrayList<>(Arrays.asList("actor1","actor2")));
        test.setDescription("coolmovie");
        test.setDirector("mr2");
        test.setTitle("magic1");
        test.setRelease_Year(1000);

        return args -> log.info ("Preloading "+ repository.save(test));
    }

}
