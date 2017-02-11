package Models.Scheduling;

/**
 * Created by Kris on 2/3/2017.
 */
public class Comment {
    private int ID;
    private int posterID;
    private String comment;

    public Comment(int posterID, String comment){
        this.posterID = posterID;
        this.comment = comment;
    }

    public void setID(int ID) {
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
