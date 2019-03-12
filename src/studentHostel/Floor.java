package studentHostel;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private static int counter = 0;
    private int numberOfFloor;
    private List<Room> rooms = new ArrayList();
    private final int MAX_NUMBER_OF_ROOMS = 4;

    public Floor() {
        counter++;
        this.numberOfFloor = counter;
        fullStartFloor();
    }

    public List<Room> getRooms() {
        return this.rooms;
    }

    private void fullStartFloor() {
        System.out.println("This is " + getNumberOfFloor() + " floor:");
        while (this.rooms.size() < getMaxNumberOfRooms()) {
            addRoomOnFloor(new Room());
        }
        System.out.println("\n");
    }

    public void fullFloor() {
        for (Room room: getRooms()) {
            room.fullRoom();
        }
    }

    private void addRoomOnFloor(Room room) {
        this.rooms.add(room);
    }

    private int getMaxNumberOfRooms() {
        return this.MAX_NUMBER_OF_ROOMS;
    }

    private int getNumberOfFloor() {
        return this.numberOfFloor;
    }
}
