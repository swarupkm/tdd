package Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Elevator {
    private int lowestFloorNumber;
    private int highestFloorNumber;
    private int currentFloorNumber;
    private List<Person> peopleList;

    private final int speed;

    {
        this.peopleList = new ArrayList<>();
        this.currentFloorNumber = 0;
        this.speed = 1;
    }

    public Elevator(int lowestFloorNumber, int highestFloorNumber) {
        this.lowestFloorNumber = lowestFloorNumber;
        this.highestFloorNumber = highestFloorNumber;
    }

    public int getSpeed() {
        return speed;
    }

    public void moveToFloor(int floorNumber) {
        if (floorNumber < lowestFloorNumber || floorNumber > highestFloorNumber)
            throw new IndexOutOfBoundsException(String.format("Given floor number %s  is outside the range of %s and %s ", floorNumber, lowestFloorNumber, highestFloorNumber));
        IntStream.range(0,Math.abs(floorNumber - this.currentFloorNumber)).forEach(i -> {
            try {
                Thread.sleep(1000/this.speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        this.currentFloorNumber = floorNumber;
    }

    public int getCurrentFloorNumber() {
        return currentFloorNumber;
    }

    public void addPerson(Person person) {
        peopleList.add(person);

    }

    public Integer getPeopleCount() {
        return peopleList.size();
    }

    public List<Person> getPeopleList() {
        return peopleList;
    }

    public void removePerson(Person person) {
        peopleList.remove(person);
    }
}
