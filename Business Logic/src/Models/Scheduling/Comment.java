package Models.Scheduling;

/**
 * Created by Kris on 2/3/2017.
 */
public class Comment {
    private long ID;
    private int posterID;
    private String comment;

    public Comment(int posterID, String comment){
        this.posterID = posterID;
        this.comment = comment;
    }

    public setID(int ID) {
        this.ID = ID;
    }

    public int getPosterID(){
        return posterID;
    }

    public int getID(){
        return ID;
    }

    public String getComment(){
        return comment;
    }
}
