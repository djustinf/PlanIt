package Models.Chunks;

import Models.Scheduling.Component;

/**
 * Created by Landon on 2/11/2017.
 */
public class RoomChunk extends Chunk {
    private Component component;

    public RoomChunk(int id, int day, int start, Component component){
        super(id, day, start);
        this.component = component;
    }
}



