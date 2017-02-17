package Models.Scheduling;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @ElementCollection
    private List<String> resources;

    @OneToMany(mappedBy = "room", cascade = CascadeType.PERSIST)
    private List<RoomOffering> offerings = new ArrayList<RoomOffering>();

    private int capacity;
    private String roomType;

    public String getRoomID() {
        return id;
    }

    public List<String> getResources() {
        return resources;
    }

    /**
     *
     *
     * @param resource - The resource to be added.
     * @return true if the list was modified as a result of this operation
     */
    public boolean addResource(String resource) {
        return resources.add(resource);
    }

    /**
     *
     *
     * @param resource - The resource to be removed
     * @return true if the list contained the specified element
     */
    public boolean removeResource(String resource) {
        return resources.remove(resource);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}