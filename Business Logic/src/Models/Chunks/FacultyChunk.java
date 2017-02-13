package Models.Chunks;

/**
 * Created by Landon on 2/11/2017.
 */
public class FacultyChunk extends Chunk{
    private int preferenceLevel;

    public FacultyChunk(int id, int day, int start, int preferenceLevel){
         super(id, day, start);
         this.preferenceLevel = preferenceLevel;
    }

    public void setEnd(int end)
    {
        super.setEnd(end);
    }
}
