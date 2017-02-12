package Models.Chunks;

/**
 * Created by Landon on 2/11/2017.
 */
public abstract class Chunk {
    private int ID;
    private int day;
    private int startTime;
    private int endTime;

    public Chunk(int id, int day, int start){
        this.ID = id;
        this.day = day;
        this.startTime = start;
    }

    public void setEnd(int end) {
        endTime = end;
    }
}
