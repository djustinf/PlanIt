package Models.Scheduling;

/**
 * Created by Kris on 2/3/2017.
 */
public class Comment {
    private int commentID;
    private int posterID;
    private String comment;

    public Comment(int posterID, String comment){
        this.posterID = posterID;
        this.comment = comment;
        commentID = System.nanoTime(); //what are the odds we assign 2 comments the same id
    }

    public int getPosterID(){
        return posterID;
    }

    public int getCommentID(){
        return commentID;
    }

    public String getComment(){
        return comment;
    }
}
