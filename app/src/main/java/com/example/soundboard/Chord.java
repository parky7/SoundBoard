package com.example.soundboard;
public class Chord {
    private int[] notes;


    public Chord(int[] notes){
        this.notes = notes;

    }

    public int[] getNotes() {
        return notes;
    }

    public void setNotes(int[] notes) {
        this.notes = notes;
    }


}
