package com.example.synthesizer;

import java.util.ArrayList;
import java.util.List;

public class Song {
    private List<Note> notes;

    public Song() {
        notes = new ArrayList<Note>();
    }

    public Song(List<Note> notes) {
        this.notes = notes;
    }

    public void add(Note n){
        notes.add(n);
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Song{" +
                "notes=" + notes +
                '}';
    }
}
