package com.example.synthesizer;

public class Note {

    public static final int WHOLE_NOTE = 1000;
    private int noteId;
    private int delay;

    public Note(int noteId, int delay) {
        this.noteId = noteId;
        this.delay = delay;
    }

    public Note(int noteId) {
        this.noteId = noteId;
        delay = WHOLE_NOTE;
    }


    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteId=" + noteId +
                ", delay=" + delay +
                '}';
    }
}
