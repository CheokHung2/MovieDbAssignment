package com.learningSpring.MovieApp;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.util.*;

@Entity
@Table(name = "movies")
public class Movie {
    private @Id @GeneratedValue Long id;
    @Column(name = "title")
    private String Title;
    @Column(name = "description")
    private String Description;
    @Column(name = "director")
    private String Director;
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name = "movie_actor",
            joinColumns = @JoinColumn(name ="movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<Actor> Actors = new HashSet<>();
    private int Release_Year;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public Set<Actor> getActors() {
        return Actors;
    }

    public void setActors(Set<Actor> actors) {
        Actors = actors;
    }

    public void addActor(Actor actor){
        this.Actors.add(actor);
        actor.getMovies().add(this);
    }

    public int getRelease_Year() {
        return Release_Year;
    }

    public void setRelease_Year(int release_Year) {
        Release_Year = release_Year;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", Director='" + Director + '\'' +
                ", Actors=" + Actors +
                ", Release_Year=" + Release_Year +
                '}';
    }

    public String toStringMovie(){
        return "Movie{" +
                "id=" + id +
                ", Title='" + Title + '\'' +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Release_Year == movie.Release_Year && Objects.equals(id, movie.id) && Objects.equals(Title, movie.Title) && Objects.equals(Description, movie.Description) && Objects.equals(Director, movie.Director) && Objects.equals(Actors, movie.Actors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Title, Description, Director, Actors, Release_Year);
    }
}
