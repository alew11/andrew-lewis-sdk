package com.andrew.lewis.sdk.andrewlewissdk.lotr.quote.model;

import java.util.Objects;

//        {
//                "_id": "5cd96e05de30eff6ebcce7e9",
//                "dialog": "Deagol!",
//                "movie": "5cd95395de30eff6ebccde5d",
//                "character": "5cd99d4bde30eff6ebccfe9e",
//                "id": "5cd96e05de30eff6ebcce7e9"
//                },
public class Quote {
    private String _id;
    private String dialog;
    private String movie;
    private String character;
    private String id;

    public Quote(String _id, String dialog, String movie, String character, String id) {
        this._id = _id;
        this.dialog = dialog;
        this.movie = movie;
        this.character = character;
        this.id = id;
    }

    public Quote() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDialog() {
        return dialog;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote that = (Quote) o;
        return Objects.equals(_id, that._id) && Objects.equals(dialog, that.dialog) && Objects.equals(movie, that.movie) && Objects.equals(character, that.character) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, dialog, movie, character, id);
    }
}
