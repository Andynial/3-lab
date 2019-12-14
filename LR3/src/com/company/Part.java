package com.company;

public class Part {
    String instrument;
    int time;

    public Part(String instrument, int time){
        this.instrument = instrument;
        this.time = time;
    }
    String GetInstrument(){ return instrument; }
    int GetTime(){ return time; }
}
