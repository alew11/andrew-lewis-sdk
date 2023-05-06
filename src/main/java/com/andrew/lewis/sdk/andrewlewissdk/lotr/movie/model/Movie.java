package com.andrew.lewis.sdk.andrewlewissdk.lotr.movie.model;

import java.util.Objects;

/**
 *             "_id": "5cd95395de30eff6ebccde56",
 *             "name": "The Lord of the Rings Series",
 *             "runtimeInMinutes": 558,
 *             "budgetInMillions": 281,
 *             "boxOfficeRevenueInMillions": 2917,
 *             "academyAwardNominations": 30,
 *             "academyAwardWins": 17,
 *             "rottenTomatoesScore": 94
 */
public class Movie {
    private String _id;
    private String name;
    private int runtimeInMinutes;
    private int budgetInMillions;

    private int boxOfficeRevenueInMillions;
    private int academyAwardNominations;
    private int academyAwardWins;
    private int rottenTomatoesScore;

    public Movie(String _id, String name, int runtimeInMinutes, int budgetInMillions, int boxOfficeRevenueInMillions, int academyAwardNominations, int academyAwardWins, int rottenTomatoesScore) {
        this._id = _id;
        this.name = name;
        this.runtimeInMinutes = runtimeInMinutes;
        this.budgetInMillions = budgetInMillions;
        this.boxOfficeRevenueInMillions = boxOfficeRevenueInMillions;
        this.academyAwardNominations = academyAwardNominations;
        this.academyAwardWins = academyAwardWins;
        this.rottenTomatoesScore = rottenTomatoesScore;
    }

    public Movie() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public int getBoxOfficeRevenueInMillions() {
        return boxOfficeRevenueInMillions;
    }

    public void setBoxOfficeRevenueInMillions(int boxOfficeRevenueInMillions) {
        this.boxOfficeRevenueInMillions = boxOfficeRevenueInMillions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRuntimeInMinutes() {
        return runtimeInMinutes;
    }

    public void setRuntimeInMinutes(int runtimeInMinutes) {
        this.runtimeInMinutes = runtimeInMinutes;
    }

    public int getBudgetInMillions() {
        return budgetInMillions;
    }

    public void setBudgetInMillions(int budgetInMillions) {
        this.budgetInMillions = budgetInMillions;
    }

    public int getAcademyAwardNominations() {
        return academyAwardNominations;
    }

    public void setAcademyAwardNominations(int academyAwardNominations) {
        this.academyAwardNominations = academyAwardNominations;
    }

    public int getAcademyAwardWins() {
        return academyAwardWins;
    }

    public void setAcademyAwardWins(int academyAwardWins) {
        this.academyAwardWins = academyAwardWins;
    }

    public int getRottenTomatoesScore() {
        return rottenTomatoesScore;
    }

    public void setRottenTomatoesScore(int rottenTomatoesScore) {
        this.rottenTomatoesScore = rottenTomatoesScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return runtimeInMinutes == movie.runtimeInMinutes && budgetInMillions == movie.budgetInMillions && boxOfficeRevenueInMillions == movie.boxOfficeRevenueInMillions && academyAwardNominations == movie.academyAwardNominations && academyAwardWins == movie.academyAwardWins && rottenTomatoesScore == movie.rottenTomatoesScore && Objects.equals(_id, movie._id) && Objects.equals(name, movie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, name, runtimeInMinutes, budgetInMillions, boxOfficeRevenueInMillions, academyAwardNominations, academyAwardWins, rottenTomatoesScore);
    }
}
