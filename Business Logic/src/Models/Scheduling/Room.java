package Models.Scheduling;

import java.util.List;

public class Room {
    private int roomID;
    private List<String> resources;
    private int capacity;
    private int roomType;

    public int getRoomID() {
        return roomID;
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