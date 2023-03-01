package com.learningSpring.MovieApp;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Movie {

    private @Id @GeneratedValue Long id;
    private String Title;
    private String Description;
    private String Director;
    @ElementCollection
    private List<String> Actors;
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

    public List<String> getActors() {
        return Actors;
    }

    public void setActors(List<String> actors) {
        Actors = actors;
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
