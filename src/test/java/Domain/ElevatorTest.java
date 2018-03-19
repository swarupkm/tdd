package Domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ElevatorTest {

    private static final int LOWEST_FLOOR_NUMBER = 0;
    private static final int HIGHEST_FLOOR_NUMBER = 20;
    private Elevator elevator;

    @Before
    public void setup(){
        elevator = new Elevator(LOWEST_FLOOR_NUMBER, HIGHEST_FLOOR_NUMBER);
    }

    @Test
    public void should_go_to_required_floor(){
        int floorNumber = 2;
        long startTime = System.currentTimeMillis();
        int beforeFloorNumber = elevator.getCurrentFloorNumber();
        elevator.moveToFloor(floorNumber);
        int afterFloorNumber = elevator.getCurrentFloorNumber();
        long endTime = System.currentTimeMillis();
        long travelTime = (endTime - startTime) / 1000;
        long floorsCovered = (long) Math.abs(beforeFloorNumber-afterFloorNumber);
        assertThat(travelTime, is(floorsCovered*elevator.getSpeed()));
        assertThat(elevator.getCurrentFloorNumber(), is(floorNumber));
    }

    @Test
    public void should_add_people(){
        Person p1 = new Person("P1", 100);
        Person p2 = new Person("P2", 100);
        elevator.addPerson(p1);
        elevator.addPerson(p2);
        assertThat(elevator.getPeopleCount()  , is(2));
        assertThat(elevator.getPeopleList(), is(Arrays.asList(new Person[]{p1, p2})));
    }

    @Test
    public void should_remove_people(){
        Person p1 = new Person("P1", 100);
        Person p2 = new Person("P2", 100);
        elevator.addPerson(p1);
        elevator.addPerson(p2);
        elevator.removePerson(p1);
        assertThat(elevator.getPeopleCount()  , is(1));
        assertThat(elevator.getPeopleList(), is(Arrays.asList(new Person[]{p2})));
    }
}
