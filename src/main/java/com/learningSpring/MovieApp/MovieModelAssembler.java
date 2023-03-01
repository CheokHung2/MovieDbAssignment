package com.learningSpring.MovieApp;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@Component
class MovieModelAssembler implements RepresentationModelAssembler<Movie,EntityModel<Movie>> {
    @Override
    public EntityModel<Movie> toModel(Movie movie) {
        return EntityModel.of(
                movie,
                linkTo(methodOn(MovieController.class).byId(movie.getId())).withSelfRel(),
                linkTo(methodOn(MovieController.class).getAll()).withRel("movies"));
    }
}
