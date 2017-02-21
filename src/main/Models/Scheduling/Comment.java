package Models.Scheduling;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Kris on 2/3/2017.
 */
@Entity
public class Comment {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private int posterID;
    private String comment;

    @ManyToOne
    private Schedule sched;

    protected Comment() {}

    public Comment(int posterID, String comment){
        this.posterID = posterID;
        this.comment = comment;
    }

    public void setID(String ID) {
        this.id = ID;
    }

    public int getPosterID(){
        return posterID;
    }

    public String getID(){
        return id;
    }

    public String getComment(){
        return comment;
    }
}
